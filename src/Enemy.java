import java.util.Random;

public class Enemy {
    private String name;
    private int hp;
    private int maxHp;
    private String location;
    private Random rand = new Random();

    public Enemy(String name, int hp, String location) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.location = location;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public String getLocation() { return location; }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
        System.out.println(name + " takes " + dmg + " damage!");
    }

    public boolean isAlive() { return hp > 0; }

    public int randomDamage() {
        return rand.nextInt(11) + 10; // 10–20 dmg
    }

    public Enemy copy() {
        return new Enemy(this.name, this.maxHp, this.location);
    }
}
