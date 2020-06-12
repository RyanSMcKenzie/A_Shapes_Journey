package Shape_Game;

public class Weapon extends Item {
    // Weapon subclass of Item, adds modifier to player damage to item features.
    private int damageMod;

    public enum CommonWeapons {
        SWORD("Sword", "Weapon", "Common", 10, "Hand"),
        DAGGER("Dagger", "Weapon", "Common", 5, "Hand"),
        STAFF("Staff", "Weapon", "Common", 12, "Hand"),
        AXE("Axe", "Weapon", "Common", 11, "Hand"),
        GREAT("Greatsword", "Weapon", "Common", 13,
                "Hand"),
        WAND("Wand", "Weapon", "Common", 7, "Hand"),
        SPEAR("Spear","Weapon","Common",10,"Hand");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int damage;
        private final String slot;

        // Constructor for any Common
        CommonWeapons(String name, String item_type, String rarity,
                      int damage, String slot) {
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.damage = damage;
            this.slot = slot;

        }
    }

    public enum UncommonWeapons {
        SSWORD("Steel Sword", "Weapon", "Uncommon", 11,
                "Hand"),
        SDAGGER("Steel Dagger", "Weapon", "Uncommon", 6,
                "Hand"),
        FWAND("Fire Wand", "Weapon", "Uncommon", 10,
                "Hand"),
        WSTAFF("Wizard Staff","Weapon","Uncommon", 12,
                "Hand"),
        SGREAT("Steel Greatsword","Weapon","Uncommon",13,
                "Hand"),
        SAXE("Steel Axe","Weapon","Uncommon",12,
                "Hand"),
        SSPEAR("Steel Spear","Weapon","Uncommon",11,
                "Hand");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int damage;
        private final String slot;

        // Constructor for any Uncommon
        UncommonWeapons(String name, String item_type, String rarity,
                        int damage, String slot) {
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.damage = damage;
            this.slot = slot;

        }
    }

    public enum RareWeapons {
        MSWORD("Mystic Sword", "Weapon", "Rare",
                12, "Hand"),
        WDAGGER("Witch Knife", "Weapon", "Rare",
                7, "Hand"),
        IWAND("Ice Wand", "Weapon", "Rare",
                13, "Hand"),
        STSTAFF("Star Staff","Weapon","Rare",
                12,"Hand"),
        MGREAT("Mystic Greatsword", "Weapon","Rare",
                14,"Hand"),
        DAXE("Diamond Axe","Weapon","Rare",
                12,"Hand"),
        OSPEAR("Obsidian Spear","Weapon","Rare",
                11,"Hand");


        // Define data members for Weapons
        private final String name;
        private final String item_type;
        private final String rarity;
        private final int damage;
        private final String slot;

        // Constructor for any Rare
        RareWeapons(String name, String item_type, String rarity,
                    int damage, String slot) {
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.damage = damage;
            this.slot = slot;

        }
    }

    public enum DivineWeapons {
        DSWORD("Dark Edge", "Weapon", "Divine",
                12, "Hand"),
        DDAGGER("Demonic Razor", "Weapon", "Divine",
                8, "Hand"),
        SWAND("Shadow Wand", "Weapon", "Divine",
                13, "Hand"),
        SSPIRE("Shamanic Spire", "Weapon","Divine",
                12, "Hand"),
        DSPEAR("Divine Spear","Weapon","Divine",
                11, "Hand");

        // Define data members for Weapons
        private final String name;
        private final String item_type;
        private final String rarity;
        private final int damage;
        private final String slot;

        // Constructor for divine weapons
        DivineWeapons(String name, String item_type, String rarity,
                      int damage, String slot) {
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.damage = damage;
            this.slot = slot;

        }
    }

    public enum LegendaryWeapons {
        RYAN_BLADE("Ryan's Blade", "Weapon", "Legendary",
                11, "Hand"),
        GRIMSTAFF("Grimoire's Staff", "Weapon","Legendary",
                10, "Hand"),
        FURY("Fury","Weapon","Legendary",11,
                "Hand"),
        SPITE("Spite","Weapon","Legendary",12,
                "Hand"),
        SHAMMER("Hammer of Storms","Weapon","Legendary",
                12, "Hand"),
        LSPEAR("Lance of the Gods","Weapon","Legendary",
                13, "Hand");

        // Define data members for Weapons
        private final String name;
        private final String item_type;
        private final String rarity;
        private final int damage;
        private final String slot;

        // Constructor for any legendary weapons
        LegendaryWeapons(String name, String item_type, String rarity,
                         int damage, String slot) {
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.damage = damage;
            this.slot = slot;

        }
    }

    public enum ForbiddenWeapons {
        SHAPESWORD("A Shape's Blade", "Weapon","Forbidden",
                14, "Hand"),
        SHAPEAXE("A Shape's Axe", "Weapon","Forbidden",
                14, "Hand");

        private final String name;
        private final String item_type;
        private final String rarity;
        private final int damage;
        private final String slot;

        ForbiddenWeapons(String name, String item_type, String rarity,
        int damage, String slot){
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.damage = damage;
            this.slot = slot;
        }
    }

    // Default constructor for JSON errors
    public Weapon() {
        super();
        this.damageMod = 0;
    }

    public Weapon(CommonWeapons weapon) {
        super(weapon.name, weapon.item_type, weapon.rarity, weapon.slot);
        this.damageMod = weapon.damage;
    }

    public Weapon(UncommonWeapons weapon) {
        super(weapon.name, weapon.item_type, weapon.rarity, weapon.slot);
        this.damageMod = weapon.damage;
        damageMod *= 2;
    }

    public Weapon(RareWeapons weapon) {
        super(weapon.name, weapon.item_type, weapon.rarity, weapon.slot);
        this.damageMod = weapon.damage;
        damageMod *= 3;
    }

    public Weapon(DivineWeapons weapon) {
        super(weapon.name, weapon.item_type, weapon.rarity, weapon.slot);
        this.damageMod = weapon.damage;
        damageMod *= 4;
    }

    public Weapon(LegendaryWeapons weapon) {
        super(weapon.name, weapon.item_type, weapon.rarity, weapon.slot);
        this.damageMod = weapon.damage;
        damageMod *= 5;
    }

    public Weapon(ForbiddenWeapons weapon) {
        super(weapon.name, weapon.item_type, weapon.rarity, weapon.slot);
        this.damageMod = weapon.damage;
        damageMod *= 7;
    }

    public int getDamageMod() {
        return damageMod;
    }
}
