package Shape_Game;

public class Chest {
    private int x;
    private int y;
    private final Item loot;

    public Chest(int xCoord, int yCoord, Item loot){
        x = xCoord;
        y = yCoord;
        this.loot = loot;

    }

    public Item getLoot(){
        return loot;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}


