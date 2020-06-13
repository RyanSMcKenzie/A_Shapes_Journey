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
        int luck = new Random().nextInt(200);
        if (luck == 199){
            int pick = new Random().nextInt(Weapon.LegendaryWeapons.values().length);
            return new Weapon(Weapon.LegendaryWeapons.values()[pick]);
        }

        if (luck < 199 & luck >= 180){
            int pick = new Random().nextInt(Weapon.DivineWeapons.values().length);
            return new Weapon(Weapon.DivineWeapons.values()[pick]);
        }

        if (luck < 180 & luck >= 140){
            int pick = new Random().nextInt(Weapon.RareWeapons.values().length);
            return new Weapon(Weapon.RareWeapons.values()[pick]);
        }

        if (luck < 140 & luck >= 80){
            int pick = new Random().nextInt(Weapon.UncommonWeapons.values().length);
            return new Weapon(Weapon.UncommonWeapons.values()[pick]);
        }

        else{
            int pick = new Random().nextInt(Weapon.CommonWeapons.values().length);
            return new Weapon(Weapon.CommonWeapons.values()[pick]);
        }
    }

    public Potion randomPotion(){
        int pick = new Random().nextInt(Potion.Potions.values().length);
        return new Potion(Potion.Potions.values()[pick]);
    }

    public Armor randomArmor(){
        int luck = new Random().nextInt(200);
        if (luck == 199){
            int pick = new Random().nextInt(Armor.LegendaryArmors.values().length);
            return new Armor(Armor.LegendaryArmors.values()[pick]);
        }

        if (luck < 199 & luck >= 180){
            int pick = new Random().nextInt(Armor.DivineArmors.values().length);
            return new Armor(Armor.DivineArmors.values()[pick]);
        }

        if (luck < 180 & luck >= 140){
            int pick = new Random().nextInt(Armor.RareArmors.values().length);
            return new Armor(Armor.RareArmors.values()[pick]);
        }

        if (luck < 140 & luck >= 80){
            int pick = new Random().nextInt(Armor.UncommonArmors.values().length);
            return new Armor(Armor.UncommonArmors.values()[pick]);
        }

        else{
            int pick = new Random().nextInt(Armor.CommonArmors.values().length);
            return new Armor(Armor.CommonArmors.values()[pick]);
        }
    }

    public Collectible randomCollectible(){
        int pick = new Random().nextInt(Collectible.Collectibles.values().length);
        return new Collectible(Collectible.Collectibles.values()[pick]);
    }

    public Item randomLoot(){
        int pick = new Random().nextInt(102);

        System.out.println(pick);
        if (pick < 33){
            return randomArmor();
        }

        else if (pick > 33 && pick < 66){
            return randomWeapon();
        }

        else if (pick > 66 && pick < 100){
            return randomPotion();
        }

        // Players have a small chance of acquiring a very rare collection item
        else{
            return randomCollectible();
        }

    }
}
