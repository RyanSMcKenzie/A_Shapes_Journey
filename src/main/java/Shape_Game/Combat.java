package Shape_Game;

import java.util.Scanner;

public class Combat {
    public Combat(){ }

    public void startCombat(Player player, Enemy enemy1, Display world){
        boolean potUsed = false;
        String potType = "";
        Item toUse = new Potion(Potion.Potions.HEALTHPOT);
        int rounds = 0;
        int turn = 1;
        enemy1.setDamage((int) (enemy1.getDamage()*world.getChaosMod()));

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
                    int dealt = player.getEffDamage()-world.getToughMod();
                    enemy1.takeDamage(dealt);
                    System.out.println("You dealt " + dealt + " damage!");
                    break;
                // Player uses an item
                case "u":
                    System.out.println("Which inventory item would you like to use?");
                    String invItem = scan.nextLine();
                    if (player.getInventory().containsKey(invItem)){
                        String iType = player.getInventory().get(invItem).getItem_type();
                        if (iType.equals("Potion")) {
                            toUse = player.getInventory().get(invItem);
                            player.use_potion(toUse);
                            potUsed = true;
                            potType = toUse.getEffect();
                        }
                    }
                    break;

                case "r":
                    System.out.println("You ran away!");
                    return;
            }
            if (enemy1.getHitpoints() <= 0) {
                String defeat = String.format("You defeated %s", enemy1.getName());
                System.out.println(defeat);
                player.gainXP(enemy1.getMaxHP()*world.getRoomMult());
                scan.nextLine();
                break;
            }

            player.takeDamage(enemy1.getDamage());
            if (player.getHealth() <= 0) {
                System.out.println("You are dead");
                scan.nextLine();
                break;
            }

            rounds += 1;
            turn *= -1;
            world.update();
        }
        if (potUsed & potType.equals("DAM")){
            player.resetPotion(toUse);
        }
    }}

