package Shape_Game;

import java.util.ArrayList;

public class Chest {
    private ArrayList<Item> Loot;
    int x;
    int y;
    private boolean looted = false;

    public Chest(int xCoord, int yCoord){
        x = xCoord;
        y = yCoord;
        //Loot.add(random item from items collection)
    }
    public ArrayList<Item> getLoot(){
        return Loot;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void placeLoot(Item loot){
        Loot.add(loot);
    }
}


