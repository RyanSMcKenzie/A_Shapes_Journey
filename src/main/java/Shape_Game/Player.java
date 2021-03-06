package Shape_Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Player {
    // Player class: level, health, base damage, inventory items arraylist
    private int level = 1;
    private int epic = 0;
    private long experiencePoints = 0;
    private long experienceToLevel = 100;
    private int maxHealth = 10;
    private int health = 10;
    private int damage = 10;
    private HashMap<String, Item> equipped  = new HashMap<>();
    private HashMap<String, Item> inventory = new HashMap<>();
    private HashMap<String, Integer> invCounts = new HashMap<>();
    private HashMap<String, String> invColors = new HashMap<>(){{
        put("Common", "\u001B[37m");
        put("Uncommon", "\u001B[32m");
        put("Rare", "\u001B[35m");
        put("Divine", "\u001b[93m");
        put("Legendary", "\u001B[31m");
        put("Forbidden", "\u001b[96m");
    }};

    public Player(){}

    //Increments player level
    public void level_up(){
        // Player levels less than 10
        if (level < 10) {
            level++;
            maxHealth = maxHealth + 5;
            health = health + 5;
            damage = damage + 1;
            experienceToLevel *= 2.5;
        }
        // Player levels between 10 and 20 gain more
        else if (level < 20) {
            level++;
            maxHealth += 10;
            health += 10;
            damage += 3;
            experienceToLevel *= 2.5;
        }
        // Once max level is reached gaining experience
        //  results in higher gains in stats, to compensate
        //  for high endgame difficulty
        else if (epic < 5){
            epic++;
            maxHealth += 15;
            health += 15;
            damage += 5;
            experiencePoints = 0;
            experienceToLevel = 10000000;
        }
    }

    public void gainXP(int exp){
        if (epic < 5) {
            experiencePoints += exp;
            while (experiencePoints >= experienceToLevel) {
                level_up();
            }
        }
    }
    public String showExp(){
        if (epic < 5) {
            return Long.toString(experiencePoints) + "/"
                    + Long.toString(experienceToLevel);
        }
        return "MAX";
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

    public int getEpic() { return epic; }

    public long getExperiencePoints() { return experiencePoints; }

    public long getExperienceToLevel() { return experienceToLevel; }

    //Returns max health of player
    public int getMaxHealth() { return maxHealth; }

    //Returns current health of player
    public int getHealth() {
        return health;
    }

    //Returns players current damage value
    public int getEffDamage() {
        int dealt = damage;

        try {
            dealt += equipped.get("Weapon").getDamageMod();
            return dealt;
        }
        catch (Exception NullPointerException){
            return dealt;
        }

    }
    public int getDamage() {
        return damage;
    }

    public void takeDamage(int dam) {
        if (equipped.containsKey("Armor")){
            dam -= equipped.get("Armor").getDamageRed();
            if (dam < 0){
                dam = 0;
            }
        }
        health = health - dam; }

    //Adds an item to player's inventory
    public void pick_up(Item new_item){
        // If the player does not have an item of this kind
        if (!inventory.containsKey(new_item.getName())) {
            inventory.put(new_item.getName(), new_item);
            invCounts.put(new_item.getName(), 1);
        }
        // If they do, increase the quantity of this item
        else {
            invCounts.put(new_item.getName(), invCounts.get(new_item.getName())+1);

            // If player has all of the collectibles for an item, fuse
            //  the pieces to give the item instead.
            if (new_item.getItem_type().equals("Collectible") &&
                    invCounts.get(new_item.getName()) == new_item.getPieces()){
                    pick_up(fuseItem(new_item));
            }
        }
    }

    public Item fuseItem(Item fusion){
        // Reduces collectible to 0 and returns constructed item
        while (invCounts.get(fusion.getName()) > 1){
            consumeItem(fusion);
        }
        consumeItem(fusion);
        return fusion.getConstructs();
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
            itemsOut.append(invColors.get(outItem.getValue().getRarity()));
            itemsOut.append(outItem.getValue().getName());
            itemsOut.append("(").append(invCounts.get(outItem.getValue().getName())
                    .toString()).append(")");
            itemsOut.append("\u001B[0m");
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
            itemsOut.append(invColors.get(outItem.getValue().getRarity()));
            itemsOut.append(outItem.getValue().getName());

            // Add a sweet comma if not the end of listing
            if (itemOutIter.hasNext()) {
                itemsOut.append(", ");
            }
        }
        itemsOut.append("\u001B[0m");
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

            case "XP":
                if (pot.getModifier() == 0){
                    experiencePoints = experienceToLevel;
                    level_up();
                }
                gainXP(pot.getModifier());
                break;
        }
        // Usage of any item, including potions, reduces its quantity
        //  and removes the item if its count reaches 0
        consumeItem(pot);
    }
    // Allows multiple avenues to consume an item aside from drinking potion
    public void consumeItem(Item toGo){
        invCounts.put(toGo.getName(), invCounts.get(toGo.getName()) - 1);
        if (invCounts.get(toGo.getName()) < 1) {
            inventory.remove(toGo.getName());
            invCounts.remove(toGo.getName());
        }
    }

    public void resetPotion(Item pot){
        // Resets effect of damage potion after a combat ends
        if (pot.getItem_type().equals("Potion") & pot.getEffect().equals("DAM")){
            damage -= pot.getModifier();
        }
    }

    public HashMap<String, Integer> getInvCounts() {
        return invCounts;
    }

    public void sellItem(Item sale){
        switch(sale.getRarity()){
            case "Common":
                gainXP(100);
                break;
            case "Uncommon":
                gainXP(200);
                break;
            case "Rare":
                gainXP(300);
                break;
            case "Divine":
                gainXP(500);
                break;
            case "Legendary":
                gainXP(1000);
                break;
        }
        consumeItem(sale);
    }
}