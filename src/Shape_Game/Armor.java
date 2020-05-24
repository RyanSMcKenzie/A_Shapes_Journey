package Shape_Game;

public class Armor extends Item {
    // Subclass of Item, Armor adds damage reduction to item features.
    private int damageRed;

    public enum Armors{
        LEATHER("Leather","Armor","Common",3,"Body"),
        ROBES("Robes","Armor","Common",1,"Body"),
        PLATE("Platemail","Armor","Common",5,"Body"),
        RYANSPLATE("Ryan's Super Plate","Armor","Rare", 15, "Body");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int reduction;
        private final String slot;

        Armors(String name, String item_type, String rarity, int reduction, String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.reduction = reduction;
            this.slot = slot;
        }
    }
    public Armor (Armors armor){
        super(armor.name, armor.item_type, armor.rarity, armor.slot);
        damageRed = armor.reduction;
    }

    public int getDamageRed(){
        return damageRed;
    }
}
