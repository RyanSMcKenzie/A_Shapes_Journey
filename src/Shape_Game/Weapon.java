package Shape_Game;

public class Weapon extends Item {
    // Weapon subclass of Item, adds modifier to player damage to item features.
    private int damageMod;

    public Weapon(String name, String item_type, String rarity, int damageMod, String slot){
        super(name, item_type, rarity, slot);
        this.damageMod = damageMod;
    }

    public int getDamageMod(){
        switch (getRarity()) {
            case "uncommon":
                damageMod *= 2;
                break;

            case "rare":
                damageMod *= 3;
                break;

            case "divine":
                damageMod *= 4;
                break;

            case "legendary":
                damageMod *= 5;
                break;
        }
        return damageMod;
    }
}
