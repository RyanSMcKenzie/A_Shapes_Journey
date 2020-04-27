package Shape_Game;


public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Room dungeon = new Room("Dungeon");
        Display world = new Display();
        world.setPlayer(player);
        player.setRoomX(1);
        player.setRoomY(1);
        world.setCurrentRoom(dungeon);
        Weapon sword = new Weapon("sword", "weapon","common",
                5, "hand");
        Chest chest1 = new Chest(3, 3);
        world.addChest(chest1);
        world.setChestLoc();
        world.setPlayerLoc();
        world.update();
        player.move(1,1);
        world.setPlayerLoc();
        world.update();
        Enemy enemy1 = new Enemy("human", 20, 5);
        Combat fight = new Combat(player, enemy1);

    }
}
