package heroes;

import fight.Enemy;
import fight.Hero;

public class Knight extends Hero {
    public Knight() {
        this.name = "Knight";
        this.maxHp = 120;
        this.hp = maxHp;
        this.attack = 25;
    }

    @Override
    public void useSpecial(Enemy enemy) {
        if (specialUsed) {
            System.out.println("Special already used!");
            specialUsed = false;
        } else {
            System.out.println("Knight uses SHIELD BASH! Blocks next attack and deals 30 damage!");
            enemy.takeDamage(30);
            blockNext = true;
            specialUsed = true;
        }

        
    }

    
}
