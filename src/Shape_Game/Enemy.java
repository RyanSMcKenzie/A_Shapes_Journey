package Shape_Game;

import java.util.ArrayList;

public class Enemy {
    private String category;
    private int hitpoints;
    private int damage;
    private java.util.ArrayList<Item> loot = new ArrayList<>();

    public Enemy(String cat, int hp, int dam){
        category = cat;
        hitpoints = hp;
        damage = dam;
    }

    public String getCategory(){
        return category;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void takeDamage(int dam) { hitpoints = hitpoints - dam; }

    public int getDamage() {
        return damage;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }
}
