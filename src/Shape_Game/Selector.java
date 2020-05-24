package Shape_Game;

import java.util.Random;

public class Selector {
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
}
