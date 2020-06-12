package Shape_Game;

public class Armor extends Item {
    // Subclass of Item, Armor adds damage reduction to item features.
    private int damageRed;

    public enum CommonArmors{
        LEATHER("Leather","Armor","Common",3,"Body"),
        ROBES("Robes","Armor","Common",1,"Body"),
        PLATE("Platemail","Armor","Common",5,"Body");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int reduction;
        private final String slot;

        CommonArmors(String name, String item_type, String rarity, int reduction,
                     String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.reduction = reduction;
            this.slot = slot;
        }
    }

    public enum UncommonArmors{
        SLEATHER("Studded Leather","Armor","Uncommon",
                5,"Body"),
        SPLATE("Steel Platemail","Armor","Uncommon",
                8,"Body");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int reduction;
        private final String slot;

        UncommonArmors(String name, String item_type, String rarity, int reduction,
                     String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.reduction = reduction;
            this.slot = slot;
        }
    }

    public enum RareArmors{
        MROBES("Mystic Robes","Armor","Rare",
                6,"Body"),
        RPLATE("Runic Platemail","Armor","Rare",
                11,"Body");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int reduction;
        private final String slot;

        RareArmors(String name, String item_type, String rarity, int reduction,
                     String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.reduction = reduction;
            this.slot = slot;
        }
    }

    public enum DivineArmors{
        ALEATHER("Angelic Leather","Armor","Divine",
                3,"Body"),
        DROBES("Divine Robes","Armor","Divine",
                1,"Body"),
        APLATE("Angelic Platemail","Armor","Divine",
                5,"Body");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int reduction;
        private final String slot;

        DivineArmors(String name, String item_type, String rarity, int reduction,
                     String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.reduction = reduction;
            this.slot = slot;
        }
    }

    public enum LegendaryArmors{
        RYANSPLATE("Ryan's Super Plate","Armor","Legendary",
                15, "Body"),
        OROBES("Overlord's Robes","Armor","Legendary",
                12,"Body");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int reduction;
        private final String slot;

        LegendaryArmors(String name, String item_type, String rarity, int reduction,
                     String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.reduction = reduction;
            this.slot = slot;
        }
    }

    public enum ForbiddenArmors{
        SHAPEPLATE("A Shape's Platemail", "Armor", "Forbidden",
                30, "Body");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int reduction;
        private final String slot;

        ForbiddenArmors(String name, String item_type, String rarity, int reduction,
                        String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.reduction = reduction;
            this.slot = slot;
        }
    }

    // Default constructor for JSON errors
    public Armor() {
        super();
        this.damageRed = 0;
    }

    public Armor (CommonArmors armor){
        super(armor.name, armor.item_type, armor.rarity, armor.slot);
        damageRed = armor.reduction;
    }

    public Armor (UncommonArmors armor){
        super(armor.name, armor.item_type, armor.rarity, armor.slot);
        damageRed = armor.reduction;
    }

    public Armor (RareArmors armor){
        super(armor.name, armor.item_type, armor.rarity, armor.slot);
        damageRed = armor.reduction;
    }

    public Armor (DivineArmors armor){
        super(armor.name, armor.item_type, armor.rarity, armor.slot);
        damageRed = armor.reduction;
    }

    public Armor (LegendaryArmors armor){
        super(armor.name, armor.item_type, armor.rarity, armor.slot);
        damageRed = armor.reduction;
    }

    public Armor(ForbiddenArmors armor) {
        super(armor.name, armor.item_type, armor.rarity, armor.slot);
        damageRed = armor.reduction;
    }

    public int getDamageRed(){
        return damageRed;
    }
}
