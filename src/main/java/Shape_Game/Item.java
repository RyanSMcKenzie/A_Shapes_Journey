package Shape_Game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Weapon.class, name = "Weapon"),

        @JsonSubTypes.Type(value = Armor.class, name = "Armor"),

        @JsonSubTypes.Type(value = Potion.class, name = "Potion"),

        @JsonSubTypes.Type(value = Collectible.class, name = "Collectible")}
)

public class Item {
    // Item superclass has name, type, and rarity
    private final String name;
    private final String item_type;
    private final String rarity;

    // Default constructor for JSON errors
    public Item(){
        this.name = null;
        this.item_type = null;
        this.rarity = null;
    }
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

    public int getDamageRed() { return 0; }
    public int getPieces() { return 0; }
    public Item getConstructs() { return null; }
}
