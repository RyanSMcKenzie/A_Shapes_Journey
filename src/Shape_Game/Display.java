package Shape_Game;

import java.util.ArrayList;

public class Display {
    private Room currentRoom;
    private Player player;
    private int playerX;
    private int playerY;
    private ArrayList<Chest> chests = new ArrayList<>();

    public Display(){}

    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    public void setPlayerX(){
        playerX = player.getRoomX();
    }

    public void setPlayerY(){
        playerY = player.getRoomY();
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void addChest(Chest chest){
        chests.add(chest);
    }
    public void setChestLoc(){
        for(int i = 0; i < chests.size(); i++){
            currentRoom.setChestLocation(chests.get(i).getX(), chests.get(i).getY());
        }
    }

    public void setPlayerLoc(){
        currentRoom.resetLoc(playerX, playerY);
        setPlayerX();
        setPlayerY();
        currentRoom.setPlayerLocation(playerX, playerY);
    }

    public void update(){
        System.out.println("Inventory: " + player.getInventory());
        System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());
        System.out.println("Damage: " + player.getDamage());
        System.out.println("Equipped Items: " + player.getEquipped());
        currentRoom.showArea();
    }
}
