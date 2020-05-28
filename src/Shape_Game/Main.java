package Shape_Game;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Room court = new Room(Room.Rooms.COURTYARD);
        Display world = new Display();
        Combat fight = new Combat();
        world.setPlayer(player);
        world.setCurrentRoom(court);
        Weapon sword = new Weapon(Weapon.Weapons.SWORD);
        player.pick_up(sword);
        Potion heal = new Potion(Potion.Potions.HEALTHPOT);
        player.pick_up(heal);
        world.update();
        Scanner eventScan = new Scanner(System.in);
        Selector select = new Selector();
        while (player.getHealth() > 0) {
            String act = eventScan.nextLine();
            switch (act) {
                case "f":
                    Enemy enemy1 = select.randomEnemy();
                    String encounter = "You encountered: " + enemy1.getName();
                    System.out.println(encounter);
                    fight.startCombat(player, enemy1, world);
                    if (player.getHealth() > 0 & enemy1.getHitpoints() <= 0){
                        if (select.lootChance()) {
                            Chest drop = new Chest(select.randomX(), select.randomY(),
                                    select.randomLoot());
                            world.addChest(drop);
                        }
                    }
                    break;

                case "s":
                    //player.pick_up(loot_item);
                    break;
                case "e":
                    // Moves an item in inventory to player's equipment
                    System.out.println("What do you want to equip?");
                    String eqItem = eventScan.nextLine();
                    if (player.getInventory().containsKey(eqItem)){
                        player.equipItem(eqItem);
                    }
                    else {
                        System.out.println("Item not in inventory");
                    }
                    break;

                case "m":
                    // Moves player to another location in room
                    System.out.println("Where on the 10x10 grid? (x,y)");
                    String[] loc = eventScan.nextLine().split(",");
                    int x_coord = Integer.parseInt(loc[0]) - 1;
                    int y_coord = Integer.parseInt(loc[1]) - 1;
                    if (x_coord >= 0 & x_coord <= 9
                    & y_coord >= 0 & y_coord <= 9){
                        world.movePlayer(x_coord, y_coord);
                    }
                    else {
                        System.out.println("You can't go there!");
                    }
                    break;

                case "l":
                    System.out.println("Your journey has ended");
                    return;
            }
            world.update();
        }
        System.out.println("Your journey has ended");
    }
}
