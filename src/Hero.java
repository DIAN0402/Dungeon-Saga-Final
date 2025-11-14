public abstract class Hero {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attack;
    protected boolean specialUsed = false;
    protected boolean blockNext = false;

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }

    public boolean isAlive() { return hp > 0; }
    public boolean specialAvailable() { return !specialUsed; }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }

    public void restoreToFull() {
        hp = maxHp;
    }

    public void resetSpecialForLevel() {
        specialUsed = false;
        blockNext = false;
    }

    public boolean blocksThisTurn() { return blockNext; }
    public void consumeBlock() { blockNext = false; }

    public abstract void useSpecial(Enemy enemy);
}
