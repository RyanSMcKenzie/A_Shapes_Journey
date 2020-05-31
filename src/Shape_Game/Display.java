package Shape_Game;

import java.util.ArrayList;

public class Display {
    private Room currentRoom;
    private Player player;
    private int playerX = 0;
    private int playerY = 0;
    private ArrayList<Chest> chests = new ArrayList<>();
    private int roomMult = 1;
    private double chaosMod = 1.1;
    private int toughMod = 0;

    public Display(){}

    public void setCurrentRoom(Room room){
        // Sets room location for player
        currentRoom = room;
        currentRoom.setPlayerLocation(0, 0);
    }

    public double getChaosMod(){
        return chaosMod;
    }

    public int getToughMod(){
        return toughMod;
    }

    public int getRoomMult(){
        // Returns room multiplier for experience gain boost on advancement
        return roomMult;
    }
    public void setPlayer(Player player){
        this.player = player;
    }

    public void addChest(Chest chest){

        chests.add(chest);
        int x = chest.getX();
        int y = chest.getY();
        if (x == playerX & y == playerY){
            x -= 1;
            y -= 1;
        }
        currentRoom.setChestLocation(x, y);
    }

    // Move player position by some (x, y) offset
    public void movePlayer(int x, int y) {
        currentRoom.resetLoc(playerX, playerY);
        playerX = x;
        playerY = y;

        // If player enters the allotted door space, move to next room
        if (x == 9 & y == 9) {

            // Try-Catch prevents crash for final room (no nextRoom)
            try {
                Room newRoom = new Room(currentRoom.getNextRoom());
                setCurrentRoom(newRoom);
                playerX = 0;
                playerY = 0;
                roomMult += 10;
                chaosMod = Math.pow(chaosMod, 2);
                toughMod += 5;
            } catch (Exception NullPointerException) {
                System.out.print("");
            }
        }
        if (currentRoom.getLoc(x, y).equals("C ")){
            for (Chest chest: chests){
                if (chest.getX() == x & chest.getY() == y){
                    player.pick_up(chest.getLoot());
                }
            }
        }
        currentRoom.setPlayerLocation(playerX, playerY);
    }

    public void dispPrompt(){
        System.out.println("What do you want to do?");
        System.out.println("(F) Pick a fight              (U) Use an Item");
        System.out.println("(S) Sell an item");
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

        currentRoom.showArea();
        this.dispPrompt();


    }
}
