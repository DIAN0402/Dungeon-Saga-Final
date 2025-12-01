package heroes;

import fight.Enemy;
import fight.Hero;

public class Wizard extends Hero {
    public Wizard() {
        this.name = "Wizard";
        this.maxHp = 80;
        this.hp = maxHp;
        this.attack = 30;
    }

    @Override
    public void useSpecial(Enemy enemy) {
        if (specialUsed) {
            System.out.println("Special already used!");
            specialUsed = false;
        } else {
            System.out.println("Wizard uses BLESSING! Restores 30 HP!");
            this.hp += 30;
            if (this.hp > this.maxHp) this.hp = this.maxHp;

            specialUsed = true;
        
        }
    }

}
