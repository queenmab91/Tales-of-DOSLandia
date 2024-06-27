import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int baseDamage = 0;
    static int baseHealth = 0;
    static int baseSpeed = 0;

    static int enemyHealth = 0;
    static int enemyDamage = 0;
    static int enemySpeed = 0;
    static String weaponChoice;

    static String enemyName;

    public static void main(String[] args) {



    /*
    --- User Chooses ---
    + Name
    + Race
    + Weapon
    */
        runGame();


/*
    --- Available Features ---

    + snarky responses
    + inventory

     */
    }

    public static void runGame() {
        enterName();
        chooseCharacter();


    }


    public static void chooseWeapon() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose a weapon:");
        System.out.println("1) Sword");
        System.out.println("2) Bow");
        System.out.println("3) Axe");
        System.out.println("4) View Weapon Descriptions ");
        String weapon = userInput.nextLine();
        int weaponInteger = Integer.parseInt(weapon);

        switch (weaponInteger) {
            case 1:
                Sword sword = new Sword();
                System.out.println("A sword? Kinda basic, but whatever. Here's your sword.");
                baseDamage += sword.getDamage();
                System.out.println("The sword has upgraded your base damage to " + baseDamage + " points.");
                weaponChoice = "sword";
                break;
            case 2:
                Bow bow = new Bow();
                System.out.println("Let me guess, you had a poster of Legolas on your wall. Enjoy sucking at archery.");
                baseDamage += bow.getDamage();
                System.out.println("The bow has upgraded your base damage to " + baseDamage + " points.");
                weaponChoice = "bow";
                break;
            case 3:
                Axe axe = new Axe();
                System.out.println("You should asked for the body spray instead of the weapon. Good luck, lumberjack.");
                baseDamage += axe.getDamage();
                System.out.println("The axe has upgraded your base damage to " + baseDamage + " points.");
                weaponChoice = "axe";
                break;
            case 4:
                Sword sword1 = new Sword();
                Bow bow1 = new Bow();
                Axe axe1 = new Axe();
                System.out.println("Sword: " + sword1.getDescription() + " | Base damage: " + sword1.getDamage());
                System.out.println("Bow: " + bow1.getDescription() + " | Base damage: " + bow1.getDamage());
                System.out.println("Axe: " + axe1.getDescription() + " | Base damage: " + axe1.getDamage());
                chooseWeapon();

        }

    }

    public static void adventure() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("You are standing in a dimly-light room. \n From the faint flicker of the torch on the wall, you can see the moss-covered stones that cocoon you. \n A faint glow shines from each cardinal direction. Which way will you go?");
        System.out.println("(N)orth");
        System.out.println("(S)outh");
        System.out.println("(E)ast");
        System.out.println("(W)est");
        String firstMove = userInput.nextLine();
        switch (firstMove.toLowerCase(Locale.ROOT)) {
            case "north":
            case "n":
                roomOne();
        }
    }


    public static void enterName() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = userInput.nextLine();
        System.out.println("Welcome, " + name + ". Prepare for your doom or your rise to glory.");
    }

    public static void chooseCharacter() {
        Scanner userInput = new Scanner(System.in);

        // prompt the user for their name

        System.out.println("Choose a race:");
        System.out.println("1) Human");
        System.out.println("2) Orc");
        System.out.println("3) Elf");
        System.out.println("4) Dwarf");
        String race = userInput.nextLine();
        int raceInteger = Integer.parseInt(race);
        switch (raceInteger) {
            case 1:
                Human human = new Human();
                System.out.println(human.getTransformationMessage());
                baseDamage += human.getBaseDamage();
                baseHealth += human.getBaseHealth();
                baseSpeed += human.getBaseSpeed();
                System.out.println("You begin with " + baseDamage + " points of damage.");
                System.out.println("You have " + baseHealth + " hit points.");
                chooseWeapon();
                adventure();
                break;
            case 2:
                Orc orc = new Orc();
                System.out.println(orc.getTransformationMessage());
                baseDamage += orc.getBaseDamage();
                baseHealth += orc.getBaseHealth();
                baseSpeed += orc.getBaseSpeed();
                System.out.println("You begin with " + baseDamage + " points of damage.");
                System.out.println("You have " + baseHealth + " hit points.");
                chooseWeapon();
                adventure();
                break;
            case 3:
                Elf elf = new Elf();
                System.out.println(elf.getTransformationMessage());
                baseDamage += elf.getBaseDamage();
                baseHealth += elf.getBaseHealth();
                baseSpeed += elf.getBaseSpeed();
                System.out.println("You begin with " + baseDamage + " points of damage.");
                System.out.println("You have " + baseHealth + " hit points.");
                chooseWeapon();
                adventure();
                break;
            case 4:
                Dwarf dwarf = new Dwarf();
                System.out.println(dwarf.getTransformationMessage());
                baseDamage += dwarf.getBaseDamage();
                baseHealth += dwarf.getBaseHealth();
                baseSpeed += dwarf.getBaseSpeed();
                System.out.println("You begin with " + baseDamage + " points of damage.");
                System.out.println("You have " + baseHealth + " hit points.");
                chooseWeapon();
                adventure();
                break;
            default:
                System.out.println("That is not a valid selection.");
        }


    }

    public static void fight() {
        while (enemyHealth > 0 && baseHealth > 0) {

            if (baseSpeed >= enemySpeed) {
                System.out.println("You attack with vigor, dealing " + baseDamage + " in damage to the " + enemyName);
                enemyHealth -= baseDamage;
                wait(800);
                System.out.println("The " + enemyName + " fights back with anger, causing " + enemyDamage + " damage.");
                baseHealth -= enemyDamage;
                wait(800);
            }

            if (baseSpeed < enemySpeed) {
                System.out.println("The enemy advances, damaging you for " + enemyDamage + " points.");
                baseHealth -= enemyDamage;
                wait(800);
                System.out.println("Enraged, you fight back, damaging the " + enemyName + " by " + baseDamage + ".");
                enemyHealth -= baseDamage;
                wait(800);
            }
        }
        if (baseHealth <= 0) {
            System.out.println("The world fades around you to black.");
        } else if (enemyHealth <= 0) {
            System.out.println("Your enemy expires with a raspy death rattle.");
        }

    }

    public static void roomOne() {
        Scanner userInput = new Scanner(System.in);
        enemyHealth = 25;
        enemySpeed = 12;
        System.out.println("You head north through a dank doorway and enter into a wide dungeon. \n There's a skeleton slumped in the far corner, looking rather skeletony. \n What would you like to do?");
        String nextMove = userInput.nextLine();
        switch (nextMove.toLowerCase(Locale.ROOT)) {
            case "look at the skeleton":
            case "look skeleton":
            case "look at skeleton":
                Random random = new Random();
                int max = 8, min = 4;
                enemyDamage = random.nextInt(max - min);
                System.out.println("You step nearer the skeleton for a closer look. \n Cobwebs wisp over the bones like pale shrouds. \n The left hand grasps the jeweled hilt of a sword.");
                wait(1500);
                wakeSkeleton();

            case "poke skeleton":
            case "poke the skeleton":
            case "poke at the skeleton":
                System.out.println("Like a weirdo, you prod the pile of bones. It feels like bones, shockingly. \n You get the feeling that the room is judging you for your choices.");
                wakeSkeleton();


        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    public static void wakeSkeleton() {
        Scanner userInput = new Scanner(System.in);
        wait(850);
        System.out.println("You get an ominous feeling from the inert bones.");
        wait(850);
        System.out.println("Despite there being no wind in these rooms, the cobwebs begin to sway.");
        wait(900);
        System.out.println("A deep red glow begins to burn like an ember in the eye sockets.");
        wait(800);
        System.out.println("As you step back, the skeleton rises with the clatter of its bones, facing you with a menacing grin.");
        wait(800);
        System.out.println("You sense the skeleton is capable of " + enemyDamage + " damage");
        System.out.println("Will you fight the skeleton? (Y)es/(N)o");
        String skeletonChoice = userInput.nextLine();
        switch (skeletonChoice.toLowerCase(Locale.ROOT)) {
            case "y":
            case "yes":
                enemyName = "skeleton";
                System.out.println("You grip your " + weaponChoice + " and prepare to fight.");
                fight();
                break;
            case "n":
            case "no":
                System.out.println("You flee back south. \n You hear the distinct bony jaw mutter 'wussy' as you disappear back whence you came.");
                break;
        }
    }
}