package Shape_Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
        for (Chest chest : chests) {
            currentRoom.setChestLocation(chest.getX(), chest.getY());
        }
    }

    public void setPlayerLoc(){
        currentRoom.resetLoc(playerX, playerY);
        setPlayerX();
        setPlayerY();
        currentRoom.setPlayerLocation(playerX, playerY);
    }

    public void update(){
        // Clear current display from terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Show items in inventory
        System.out.println("Inventory: " + player.getInventory());

        // Show health
        System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());

        // Show current damage
        System.out.println("Damage: " + player.getDamage());

        // Show equipped items
        StringBuilder itemsOut = new StringBuilder();
        // Iterate through equipped items and concatenate names to out
        Iterator <Map.Entry <String, Item> >itemOutIter
                = player.getEquipped().entrySet().iterator();

        while (itemOutIter.hasNext()) {
            Map.Entry<String, Item> outItem = itemOutIter.next();
            itemsOut.append(outItem.getValue().getName());

            // Add a sweet comma if not the end of listing
            if (itemOutIter.hasNext()) {
                itemsOut.append(", ");
            }
        }

        System.out.println("Equipped Items: " + itemsOut.toString());
        this.setPlayerLoc();
        currentRoom.showArea();
    }
}
