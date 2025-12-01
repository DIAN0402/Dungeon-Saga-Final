package heroes;

import fight.Enemy;
import fight.Hero;

public class Assassin extends Hero {
    public Assassin() {
        this.name = "Assassin";
        this.maxHp = 90;
        this.hp = maxHp;
        this.attack = 35;
    }

    @Override
    public void useSpecial(Enemy enemy) {
        if (specialUsed) {
            System.out.println("Special already used!");
            specialUsed = false;
        } else {
            System.out.println("Assassin uses FATAL BLOW! Deals 50 damage but loses 25 HP!");
            enemy.takeDamage(50);
            this.takeDamage(25);
            specialUsed = true;
        }

        
    }

    
}
