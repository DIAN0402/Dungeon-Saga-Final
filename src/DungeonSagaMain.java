import java.util.*;

public class DungeonSagaMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("      DUNGEON SAGA      ");
        System.out.println("==============================\n");

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Hero hero = chooseHero();

        Enemy[] levels = {
            new Enemy("White Beast", 80, "Whispering Passage"),
            new Enemy("Undead Knight", 120, "Catacombs of the Chasm"),
            new Enemy("Lord Vulcan", 150, "Surtur’s Fiery Chamber")
        };

        for (int i = 0; i < levels.length; i++) {
            hero.restoreToFull();
            hero.resetSpecialForLevel();

            Enemy enemy = levels[i].copy();
            System.out.println("\n--- LEVEL " + (i + 1) + " ---");
            System.out.println("Location: " + enemy.getLocation());
            System.out.println("Enemy: " + enemy.getName() + " (" + enemy.getMaxHp() + " HP)\n");

            if (!fight(hero, enemy)) {
                System.out.println("GAME OVER. You have fallen.");
                return;
            }

            System.out.println("\nLEVEL CLEARED! HP restored.\n");
        }

        System.out.println("CONGRATULATIONS! You have conquered the dungeon!");
    }

    private static Hero chooseHero() {
        while (true) {
            System.out.println("Choose your hero:");
            System.out.println("1) Knight — 120 HP | 25 ATK | Special: Shield Bash (Block all dmg + 30 dmg)");
            System.out.println("2) Assassin — 90 HP | 35 ATK | Special: Fatal Blow (50 dmg but lose 25 HP)");
            System.out.println("3) Wizard — 80 HP | 30 ATK | Special: Blessing (Heal 30 HP)");
            System.out.print("Enter 1-3: ");

            switch (scanner.nextLine()) {
                case "1": return new Knight();
                case "2": return new Assassin();
                case "3": return new Wizard();
                default: System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    private static boolean fight(Hero hero, Enemy enemy) {
        boolean defend = false;

        while (hero.isAlive() && enemy.isAlive()) {
            System.out.println("--- STATUS ---");
            System.out.println(hero.getName() + " HP: " + hero.getHp() + "/" + hero.getMaxHp());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp() + "/" + enemy.getMaxHp());

            System.out.println("\nChoose Action:");
            System.out.println("1) Attack");
            System.out.println("2) Defend");
            System.out.println("3) Special" + (hero.specialAvailable() ? "" : " (USED)"));
            System.out.print("Input: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    enemy.takeDamage(hero.getAttack());
                    break;
                case "2":
                    defend = true;
                    System.out.println(hero.getName() + " prepares to block the next attack!");
                    break;
                case "3":
                    hero.useSpecial(enemy);
                    break;
                default:
                    System.out.println("Invalid input. You lose your turn!");
            }

            if (!enemy.isAlive()) return true;

            int dmg = enemy.randomDamage();

            if (defend) {
                System.out.println(hero.getName() + " blocks all damage!");
                defend = false;
            } else if (hero.blocksThisTurn()) {
                System.out.println(hero.getName() + " blocks all damage with Shield Bash!");
                hero.consumeBlock();
            } else {
                System.out.println(enemy.getName() + " hits for " + dmg + " damage!");
                hero.takeDamage(dmg);
            }
        }
        return hero.isAlive();
    }
}
