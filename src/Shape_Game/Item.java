package Shape_Game;

import java.util.HashMap;

public class Item {
    // Item superclass has name, type, and rarity
    private final String name;
    private final String item_type;
    private final String rarity;

    public Item(String name, String item_type, String rarity, String slot){
        this.name = name;
        this.item_type = item_type;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }
    public String getItem_type(){
        return item_type;
    }
    public String getRarity(){ return rarity; }

    public int getDamageMod(){
        return 0;
    }
    public String getEffect() {return "None"; }
    public int getModifier() {return 0;}
}
