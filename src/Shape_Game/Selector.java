package Shape_Game;

import java.util.Random;

public class Selector {
    public int randomX(){
        return new Random().nextInt(9);
    }

    public int randomY(){
        return new Random().nextInt(9);
    }

    public boolean lootChance(){
        int dropped = new Random().nextInt(3);
        return dropped == 2;
    }

    public Enemy randomEnemy(){
        int pick = new Random().nextInt(Enemy.Enemies.values().length);
        return new Enemy(Enemy.Enemies.values()[pick]);
    }

    public Weapon randomWeapon(){
        int pick = new Random().nextInt(Weapon.Weapons.values().length);
        return new Weapon(Weapon.Weapons.values()[pick]);
    }

    public Potion randomPotion(){
        int pick = new Random().nextInt(Potion.Potions.values().length);
        return new Potion(Potion.Potions.values()[pick]);
    }

    public Armor randomArmor(){
        int pick = new Random().nextInt(Armor.Armors.values().length);
        return new Armor(Armor.Armors.values()[pick]);
    }

    public Item randomLoot(){
        int pick = new Random().nextInt(3);

        System.out.println(pick);
        if (pick == 0){
            return randomArmor();
        }

        if (pick == 1){
            return randomWeapon();
        }

        else {
            return randomPotion();
        }

    }
}
