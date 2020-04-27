package Shape_Game;

public class Weapon extends Item {
    // Weapon subclass of Item, adds modifier to player damage to item features.
    private int damageMod;

    public Weapon(String name, String item_type, String rarity, int damageMod, String slot){
        super(name, item_type, rarity, slot);
        this.damageMod = damageMod;
    }

    int getDamageMod(){
        return damageMod;
    }
}
