package Shape_Game;

public class Weapon extends Item {
    // Weapon subclass of Item, adds modifier to player damage to item features.
    private int damageMod;
    public enum Weapons {
        SWORD("Sword","Weapon","Common",10,"Hand"),
        SSWORD("Steel Sword","Weapon","Uncommon",11,"Hand"),
        MSWORD("Mystic Sword","Weapon","Rare",13,"Hand"),
        DSWORD("Dark Edge","Weapon","Divine",14,"Hand"),
        DAGGER("Dagger","Weapon","Common",5,"Hand"),
        SDAGGER("Steel Dagger","Weapon","Uncommon",6,"Hand"),
        WDAGGER("Witch Knife","Weapon","Rare",7,"Hand"),
        DDAGGER("Demonic Razor","Weapon","Divine",8,"Hand"),
        STAFF("Staff", "Weapon","Common",12,"Hand"),
        AXE("Axe","Weapon","Common",11,"Hand"),
        SCIMITAR("Scimitar","Weapon","Common",11,"Hand"),
        GREATSWORD("Greatsword","Weapon","Common",13,"Hand"),
        WAND("Wand","Weapon","Common",7,"Hand"),
        FWAND("Fire Wand","Weapon","Uncommon",10,"Hand"),
        IWAND("Ice Wand","Weapon","Rare",13,"Hand"),
        SWAND("Shadow Wand","Weapon","Divine",17,"Hand"),
        RYAN_BLADE("Ryan's Blade","Weapon","Legendary",
                11,"Hand");

        // Define data members for Weapons
        private final String name;
        private final String item_type;
        private final String rarity;
        private final int damage;
        private final String slot;

        // Constructor for any weapon
        Weapons (String name, String item_type, String rarity,
                                 int damage, String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.damage = damage;
            this.slot = slot;

        }
    }
    public Weapon(Weapons weapon) {
        super(weapon.name, weapon.item_type, weapon.rarity, weapon.slot);
        this.damageMod = weapon.damage;
        switch (getRarity()) {
            case "Uncommon":
                damageMod *= 2;
                break;

            case "Rare":
                damageMod *= 3;
                break;

            case "Divine":
                damageMod *= 4;
                break;

            case "Legendary":
                damageMod *= 5;
                break;
        }
    }

    public int getDamageMod() {
        return damageMod;
    }
}
