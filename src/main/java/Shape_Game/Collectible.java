package Shape_Game;

public class Collectible extends Item {
    private int pieces;
    private Item constructs = null;

    public enum Collectibles{

        SHAPEPIECE("Shard of the Shape's Blade", "Collectible",
                "Forbidden","None",8,
                new Weapon(Weapon.ForbiddenWeapons.SHAPESWORD)),
        SHAPEPIECEA("Shard of the Shape's Armor", "Collectible",
        "Forbidden","None",12,
                new Armor(Armor.ForbiddenArmors.SHAPEPLATE));

        private final int pieces;
        private final Item constructs;
        private final String name;
        private final String item_type;
        private final String rarity;
        private final String slot;

        Collectibles(String name, String item_type, String rarity, String slot,
                     int pieces, Item constructs) {
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.slot = slot;
            this.pieces = pieces;
            this.constructs = constructs;
        }
    }

    public Collectible(){
        super();
        this.pieces = 0;
        this.constructs = null;
    }

    public Collectible(Collectibles collect){
        super(collect.name, collect.item_type, collect.rarity, collect.slot);
        this.pieces = collect.pieces;
        this.constructs = collect.constructs;
    }

    public int getPieces() {
        return pieces;
    }

    public Item getConstructs(){
        return constructs;
    }
}
