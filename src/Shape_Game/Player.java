package Shape_Game;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    // Player class: level, health, base damage, inventory items arraylist
    private int level = 0;
    private int maxHealth = 10;
    private int health = 10;
    private int damage = 10;
    private Room currentRoom;
    private int roomX = 0;
    private int roomY = 4;
    private HashMap<String, Item> equipped  = new HashMap<>();
    private java.util.ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(){}
    //Increments player level
    public void level_up(){
        level++;
        maxHealth = maxHealth + 5;
    }
    //Returns health to player
    public void heal(int amount){
        if ((health + amount) > maxHealth){
            health = maxHealth;
        }
        else health = health + amount;
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
        inventory.add(new_item);
    }

    //Returns contents of players inventory
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    //Puts item into equipped location slot
    public void equipItem(Item to_equip) {
        equipped.put(to_equip.getItem_type(), to_equip);
    }

    //Returns players current equipped items
    public HashMap<String, Item> getEquipped(){ return equipped; }

}