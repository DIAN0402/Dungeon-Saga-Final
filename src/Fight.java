import java.util.*;

public class Fight {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean fight(Hero hero, Enemy enemy, Enemy location) {
        boolean defend = false;
        fightanimation action = new fightanimation();

        while (hero.isAlive() && enemy.isAlive()) {
            System.out.println("--- STATUS ---");
            System.out.println(hero.getName() + " HP: " + hero.getHp() + "/" + hero.getMaxHp());
            System.out.println(enemy.getName() + " HP: " + enemy.getHp() + "/" + enemy.getMaxHp());

            action.IdleAnimation(hero, enemy, hero.getName(), location.getLocation());
            

            System.out.println("\nChoose Action:");
            System.out.println("1) Attack");
            System.out.println("2) Defend");
            System.out.println("3) Special" + (hero.specialAvailable() ? "" : " (USED)"));
            System.out.print("Input: ");
            String choice = scanner.nextLine();
            
            
            
            switch (choice) {
                case "1":
                    enemy.takeDamage(hero.getAttack());
                    action.FightAnimation(hero, enemy, hero.getName(), location.getLocation(), choice);
                    break;
                case "2":
                    defend = true;
                    System.out.println(hero.getName() + " prepares to block the next attack!");
                    action.FightAnimation(hero, enemy, hero.getName(), location.getLocation(), choice);
                    break;
                case "3":
                    hero.useSpecial(enemy);
                    action.FightAnimation(hero, enemy, hero.getName(), location.getLocation(), choice);
                    break;
                default:
                    action.FightAnimation(hero, enemy, hero.getName(), location.getLocation(), choice);
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
