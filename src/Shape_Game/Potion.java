package Shape_Game;

public class Potion extends Item {
    private final String effect;
    private final int modifier;

    // Enumerate potion types
    public enum Potions {
        HEALTHPOT("Health Potion", "Potion", "Common",
                "None", "HP", 10),
        GHEALTHPOT("Greater Health Potion", "Potion", "Rare",
                "None", "HP", 25),
        DAMPOT("Damage Potion", "Potion", "Uncommon",
                "None", "DAM",10);

        private final String name;
        private final String item_type;
        private final String rarity;
        private final String slot;
        private final String effect;
        private final int modifier;

        // Potion constructor
        Potions(String name, String item_type, String rarity, String slot,
                String effect, int modifier) {
            this.name = name;
            this.item_type = item_type;
            this.rarity = rarity;
            this.slot = slot;
            this.effect = effect;
            this.modifier = modifier;
        }
    }

    // Potion object constructs as item plus effect and modifier
    public Potion(Potions potion){
        super(potion.name, potion.item_type, potion.rarity, potion.slot);
        this.effect = potion.effect;
        this.modifier = potion.modifier;

    }

    // Return effect
    public String getEffect(){
        return effect;
    }

    // Return modifier
    public int getModifier(){
        return modifier;
    }
}
