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

    public void dispPrompt(){
        System.out.println("What do you want to do?");
        System.out.println("(F) Pick a fight");
        System.out.println("(S) Search for loot");
        System.out.println("(E) Equip item");
        System.out.println("(M) Move");
        System.out.println("(L) Let darkness consume you");
    }

    public void update(){
        // Clear current display from terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Show level and experience
        System.out.println("Level: " + player.getLevel());
        System.out.println("Experience: " + player.showExp());
        // Show items in inventory
        System.out.println("Inventory: " + player.showInventory());

        // Show health
        System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());

        // Show current damage
        System.out.println("Damage: " + player.getDamage());



        System.out.println("Equipped Items: " + player.showEquipped());
        this.setPlayerLoc();
        currentRoom.showArea();
        this.dispPrompt();
    }
}
