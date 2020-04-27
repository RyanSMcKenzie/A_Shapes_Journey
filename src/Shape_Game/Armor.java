package Shape_Game;

public class Armor extends Item {
    // Subclass of Item, Armor adds damage reduction to item features.
    private int damageRed;

    public Armor (String name, String item_type, String rarity, int reduction, String slot){
        super(name, item_type, rarity, slot);
        damageRed = reduction;
    }

    public int getDamageRed(){
        return damageRed;
    }
}
