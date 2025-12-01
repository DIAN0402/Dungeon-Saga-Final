import java.util.*;

import displayfights.DisplayFight;
import fight.Enemy;
import fight.Fight;
import fight.Hero;
import heroes.Assassin;
import heroes.Knight;
import heroes.Wizard;

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
        DisplayFight display = new DisplayFight();

        Enemy[] levels = {
            new Enemy("White Beast", 80, "Whispering Passage"),
            new Enemy("Red Dragon", 120, "Surtur’s Fiery Chamber"),
            new Enemy("Demon King", 150, "Throne of the Chasm")
        };

        for (int i = 0; i < levels.length; i++) {
            hero.restoreToFull();
            hero.resetSpecialForLevel();

            Enemy enemy = levels[i].copy();
            System.out.println("\n--- LEVEL " + (i + 1) + " ---");
            System.out.println("Location: " + enemy.getLocation());
            System.out.println("Enemy: " + enemy.getName() + " (" + enemy.getMaxHp() + " HP)\n");

            if (!Fight.fight(hero, enemy, enemy)) {
                System.out.println("GAME OVER. You have fallen.");
                display.DisplayLose();
                return;
            }

            System.out.println("\nLEVEL CLEARED! HP restored.\n\n\n\n\n\n");
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

    
}
