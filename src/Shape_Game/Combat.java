package Shape_Game;

import java.util.Scanner;

public class Combat {
    private int rounds = 0;
    private int turn = 1; // Turn alternates between -1 and 1 depending on turn
    public Combat(Player player, Enemy enemy1){
        // While player and enemy are alive, combat continues
        while (player.getHealth() > 0 && enemy1.getHitpoints() > 0){
            Scanner scan = new Scanner(System.in);
            System.out.println("What action will you take?");
            System.out.println("A: Attack");
            System.out.println("U: Use inventory item");
            System.out.println("R: Run");
            String Action = scan.nextLine();
            // Player action decision
            switch (Action){
                case "a":
                    enemy1.takeDamage(player.getDamage());
                    break;
                // Currently items do not have usage abilities
                case "u":
                    System.out.println("Which inventory item would you like to use?");
                    String invItem = scan.nextLine();
                    break;

                case "r":
                    System.out.println("You ran away!");
                    return;
            }
            player.takeDamage(enemy1.getDamage());
            if (player.getHealth() <= 0) {
                System.out.println("You are dead");
                break;
            }

            if (enemy1.getHitpoints() <= 0) {
                String defeat = String.format("You defeated %s", enemy1.getName());
                System.out.println(defeat);
            }
            rounds += 1;
            turn *= -1;

        }
    }
}
