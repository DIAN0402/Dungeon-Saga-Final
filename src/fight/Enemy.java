package fight;

import java.util.Random;

public class Enemy {
    private String enemyName;
    private int hp;
    private int maxHp;
    private String location;
    private Random rand = new Random();

    public Enemy(String enemyName, int hp, String location) {
        this.enemyName = enemyName;
        this.hp = hp;
        this.maxHp = hp;
        this.location = location;
    }

    public String getName() { return enemyName; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public String getLocation() { return location; }

    public boolean takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
        System.out.println(enemyName + " takes " + dmg + " damage!");
        return isAlive();
    }
    public boolean isAlive() { return hp > 0; }

    public int randomDamage() {
        return rand.nextInt(11) + 10; // 10–20 dmg
    }

    public Enemy copy() {
        return new Enemy(this.enemyName, this.maxHp, this.location);
    }
}
