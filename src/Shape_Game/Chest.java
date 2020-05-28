package Shape_Game;

import java.util.ArrayList;

public class Chest {
    private int x;
    private int y;
    private Item loot;
    private boolean looted = false;

    public Chest(int xCoord, int yCoord, Item loot){
        x = xCoord;
        y = yCoord;
        this.loot = loot;

    }

    public Item getLoot(){
        return loot;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}


