package Shape_Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Player {
    // Player class: level, health, base damage, inventory items arraylist
    private int level = 1;
    private int experiencePoints = 0;
    private int experienceToLevel = 100;
    private int maxHealth = 10;
    private int health = 10;
    private int damage = 10;
    private Room currentRoom;
    private int roomX = 0;
    private int roomY = 4;
    private HashMap<String, Item> equipped  = new HashMap<>();
    private HashMap<String, Item> inventory = new HashMap<>();

    public Player(){}

    //Increments player level
    public void level_up(){
        level++;
        maxHealth = maxHealth + 5;
        health = health + 5;
        damage = damage + 1;
    }

    public void gainXP(int exp){
        experiencePoints += exp;
        if (experiencePoints >= experienceToLevel){
            level_up();
            experienceToLevel *= 2.5;
        }
    }
    public String showExp(){
        return Integer.toString(experiencePoints) + "/"
                + Integer.toString(experienceToLevel);
    }
    //Returns health to player
    public void heal(int amount){
        health = Math.min((health + amount), maxHealth);
    }

    //Increases players damage amount
    public void damage_boost(int amount){
        damage = damage + amount;
    }

    //Returns current level of player
    public int getLevel() {
        return level;
    }

    //Returns max health of player
    public int getMaxHealth() { return maxHealth; }

    //Returns current health of player
    public int getHealth() {
        return health;
    }

    //Returns players current damage value
    public int getDamage() {
        int dealt = damage;

        try {
            dealt += equipped.get("Weapon").getDamageMod();
            return dealt;
        }
        catch (Exception NullPointerException){
            return dealt;
        }

    }

    public void takeDamage(int dam) { health = health - dam; }
    //Players current room
    public Room getCurrentRoom(){
        return currentRoom;
    }

    // Change current player room
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    // Get X-coordinate of player in room
    public int getRoomX() {
        return roomX;
    }

    // Get Y-coordinate of player in room
    public int getRoomY() {
        return roomY;
    }

    // Set X-coord of player in room
    public void setRoomX(int roomX) {
        this.roomX = roomX;
    }

    // Set Y-coord of player in room
    public void setRoomY(int roomY) {
        this.roomY = roomY;
    }

    // Move player position by some (x, y) offset
    public void move(int x, int y) {
        setRoomX(x);
        setRoomY(y);
    }
    //Adds an item to player's inventory
    public void pick_up(Item new_item){
        inventory.put(new_item.getName(),new_item);
    }

    //Returns contents of players inventory
    public HashMap<String, Item> getInventory() {
        return inventory;
    }

    public String showInventory() {
        // Show inventory items
        StringBuilder itemsOut = new StringBuilder();
        // Iterate through inventory items and concatenate names to out
        Iterator <Map.Entry <String, Item> >itemOutIter
                = getInventory().entrySet().iterator();

        while (itemOutIter.hasNext()) {
            Map.Entry<String, Item> outItem = itemOutIter.next();
            itemsOut.append(outItem.getValue().getName());

            // Add a sweet comma if not the end of listing
            if (itemOutIter.hasNext()) {
                itemsOut.append(", ");
            }
        }
        return itemsOut.toString();
    }

    //Puts item into equipped location slot
    public void equipItem(String to_equip) {
        if (inventory.containsKey(to_equip)){
            equipped.put(inventory.get(to_equip).getItem_type(),
                    inventory.get(to_equip));
            }
        }

    //Returns players current equipped items
    public HashMap<String, Item> getEquipped(){ return equipped; }

    public String showEquipped() {
        // Show equipped items
        StringBuilder itemsOut = new StringBuilder();
        // Iterate through equipped items and concatenate names to out
        Iterator<Map.Entry <String, Item> > itemOutIter
                = getEquipped().entrySet().iterator();

        while (itemOutIter.hasNext()) {
            Map.Entry<String, Item> outItem = itemOutIter.next();
            itemsOut.append(outItem.getValue().getName());

            // Add a sweet comma if not the end of listing
            if (itemOutIter.hasNext()) {
                itemsOut.append(", ");
            }
        }
        return itemsOut.toString();
    }

    // Allows players to consume potion items
    public void use_potion(Item pot){
        if (!pot.getItem_type().equals("Potion")){
            return;
        }
        String eff = pot.getEffect();

        // Effect depends on potion effect and modifier quantity
        switch (eff){
            case "HP":
                heal(pot.getModifier());
                break;

            case "DAM":
                damage += pot.getModifier();
                break;
        }
        inventory.remove(pot.getName());
    }
}