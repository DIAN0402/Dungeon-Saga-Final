package displayfights;

import fight.Hero;
import fight.Enemy;

public class fightanimation {
    private String heroName;
    private String location;

    public String getName() { return heroName; }
    public String getLocation() { return location; }

    public void IdleAnimation (Hero hero, Enemy enemy, String heroName, String location) {
        DisplayFight display = new DisplayFight();

        switch (heroName) {
            case "Knight":
                switch(location) {
                    case "Whispering Passage":
                        if(enemy.isAlive() == true && !((enemy.getHp() < enemy.getMaxHp()) || (enemy.getHp() > enemy.getMaxHp()))) {
                            display.DisplayKnightvsWhiteBeast();
                            break;
                        }
                    case "Surtur’s Fiery Chamber": 
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp()) {
                            display.DisplayKnightvsDragon();
                            break;
                        }
                    case "Throne of the Chasm": 
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp()) {
                            display.DisplayKnightvsDemonking();
                            break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case "Assassin":
                switch(location) {
                    case "Whispering Passage":
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp()) {
                            display.DisplayAssassinvsWhiteBeast();
                            break;
                        }
                    case "Surtur’s Fiery Chamber": 
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp()) {
                            display.DisplayAssassinvsDragon();
                            break;
                        }
                        break;
                    case "Throne of the Chasm": 
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp()) {
                            display.DisplayAssasinvsDemonking();
                            break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case "Wizard":
                switch(location) {
                    case "Whispering Passage":
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp()) {
                            display.DisplayWizardvsWhiteBeast();
                            break;
                        }
                    case "Surtur’s Fiery Chamber": 
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp()) {
                            display.DisplayWizardvsDragon();
                            break;
                        }
                        break;
                    case "Throne of the Chasm": 
                        if(enemy.isAlive() == true && enemy.getHp() == enemy.getMaxHp())    {
                            display.DisplayWizardvsDemonking();
                            break;
                        }
                    default:
                        break;
                }
                break;
            default:
                System.out.println("Unknown Hero: " + hero);
                break;
        }
    }


    public void FightAnimation (Hero hero, Enemy enemy, String heroName, String location, String choice) {
        DisplayFight display = new DisplayFight();

        switch (heroName) {
            case "Knight":
                switch(location) {
                    case "Whispering Passage":
                        if(choice.equals("1")) { // Attack
                            display.DisplayKnightAttacksWhiteBeast();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayKnightDefendWhiteBeast();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayAssassinSkillonWhiteBeast();
                        } else {
                            display.DisplayWhiteBeastAttacksKnight();
                        }
                        break;
                    case "Surtur’s Fiery Chamber":
                        if(choice.equals("1")) { // Attack
                            display.DisplayKnightAttacksDragon();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayKnightDefendDragon();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayKnightSkillonDragon();
                        } else {
                            display.DisplayDragonAttacksKnight();
                        }
                        break;
                    case "Throne of the Chasm":
                        if(choice.equals("1")) { // Attack  
                            display.DisplayKnightAttacksDemonking();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayKnightDefendDemonking();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayKnightSkillonDemonking();
                        } else {
                            display.DisplayDemonkingAttacksKnight();
                        }
                }
                break;
            case "Assassin":
                switch(location) {
                    case "Whispering Passage":
                        if(choice.equals("1")) { // Attack
                            display.DisplayAssassinAttacksWhiteBeast();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayAssassinDefendWhiteBeast();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayAssassinSkillonWhiteBeast();
                        } else {
                            display.DisplayWhiteBeastAttacksAssassin();
                        }
                        break;
                    case "Surtur’s Fiery Chamber":
                        if(choice.equals("1")) { // Attack
                            display.DisplayAssassinAttacksDragon();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayAssassinDefendDragon();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayAssassinSkillonDragon();
                        } else {
                            display.DisplayDragonAttacksAssassin();
                        }
                        break;
                    case "Throne of the Chasm":
                        if(choice.equals("1")) { // Attack  
                            display.DisplayAssassinAttacksDemonking();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayAssassinDefendDemonking();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayAssassinSkillonDemonking();
                        } else {
                            display.DisplayDemonkingAttacksAssassin();
                        }
                    default:
                        break;
                }
                break;
            case "Wizard":
                switch(location) {
                    case "Whispering Passage":
                        if(choice.equals("1")) { // Attack
                            display.DisplayWizardAttacksWhiteBeast();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayWizardDefendWhiteBeast();
                        } else if (choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayWizardSkillonWhiteBeast();
                        } else {
                            display.DisplayWhiteBeastAttacksWizard();
                        }
                        break;
                    case "Surtur’s Fiery Chamber":
                        if(choice.equals("1")) { // Attack
                            display.DisplayWizardAttackDragon();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayWizardDefendDragon();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayWizardSkillonDragon();
                        } else {
                            display.DisplayDragonAttackWizard();
                        }
                        break;
                    case "Throne of the Chasm":
                        if(choice.equals("1")) { // Attack  
                            display.DisplayWizardAttacksDemonking();
                        } else if(choice.equals("2")) { // Defend
                            display.DisplayWizardDefendDemonking();
                        } else if(choice.equals("3") && !hero.specialAvailable()) { // Special
                            display.DisplayWizardSkillonDemonking();
                        } else {
                            display.DisplayDemonkingAttacksWizard();
                        }
                    default:
                        break;
                }
                break;
            default:
                System.out.println("Unknown Hero: " + heroName);
                break;
        }
    }
}