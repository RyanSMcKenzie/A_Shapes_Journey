package Shape_Game;

import java.util.ArrayList;

public class Enemy {
    // Enemy class data members
    private String category;
    private int hitpoints;
    private int maxHP;
    private int damage;
    private String name;
    private java.util.ArrayList<Item> loot = new ArrayList<>();

    public enum Enemies {
        SKELETON("Skeleton","Undead",10,5),
        ZOMBIE("Zombie","Undead",12,6),
        HOBGOBLIN("Hobgoblin","Gremlin",20,8),
        BANDIT("Bandit","Human",20,10),
        GHOST("Ghost","Undead",25,15),
        FIEND("Fiend","Demon",40,25),
        CAPTAIN_JOE("Captain Joe","Undead",55,30),
        DR_ZOMB("Doctor Zomb","Human",75,40);


        // All enemies have these data members
        private final String name;
        private final String category;
        private final int hitpoints;
        private final int damage;

        // Constructor for an enemy
        Enemies(String name, String category, int hitpoints, int damage){
            this.name = name;
            this.category = category;
            this.hitpoints = hitpoints;
            this.damage = damage;
        }
    }

    public Enemy(Enemies enemy){
        this.name = enemy.name;
        this.category = enemy.category;
        this.hitpoints = enemy.hitpoints;
        this.damage = enemy.damage;
        maxHP = hitpoints;
    }

    public String getName() {
        return name;
    }
    public String getCategory(){
        return category;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getMaxHP(){
        return maxHP;
    }

    public void takeDamage(int dam) { hitpoints = hitpoints - dam; }

    public int getDamage() {
        return damage;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }
}
