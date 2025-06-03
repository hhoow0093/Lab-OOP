package Tugas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void waitUserInput() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void viewMenu() {
        System.out.println("Hello minna san");
        System.out.println("Welcome to RPG game");
        System.out.println("1. Add player");
        System.out.println("2. Hit boss");
        System.out.println("3. Exit game");
    }

    public static void addPlayer() {

    }
    
    public static void seedPlayer(ArrayList<Player> playerArr) {
        Player knight = new Player("Knight", 200, 15, 30);
        Player archer = new Player("Archer", 50, 18, 40);
        Player barbarians = new Player("Barbarian", 300, 23, 50);
        Player ninja = new Player("Ninja", 500, 70, 80);
        playerArr.add(archer);
        playerArr.add(knight);
        playerArr.add(barbarians);
        playerArr.add(ninja);

    }
    
    public static void addPlayer(ArrayList<Player> playerArr, Scanner scanner) {
        String name;
        int hitpoint;
        int damage;
        int energy;

        System.out.print("Nama hero: ");
        name = scanner.nextLine();

        System.out.print("hitpoint: ");
        hitpoint = scanner.nextInt();
        scanner.nextLine();

        System.out.print("damage: ");
        damage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("energy: ");
        energy = scanner.nextInt();
        scanner.nextLine();

        Player newPlayer = new Player(name, hitpoint, damage, energy);
        playerArr.add(newPlayer);

    }

    public static void displayHero(ArrayList<Player> playerArr) {
        for (int i = 0; i < playerArr.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, playerArr.get(i).getName()));
            System.out.println(String.format("Hit Point        : %d", playerArr.get(i).getHitPoint()));
            System.out.println(String.format("Damage           : %d", playerArr.get(i).getDamage()));
            System.out.println(String.format("Energy           : %d", playerArr.get(i).getEnergy()));
            System.out.println("--------------------------");
        }
        System.out.print("silahkan pilih nomor character: ");
    }
    
    public static void hitBoss(ArrayList<Player> playerArr, Scanner scanner, BigBoss bigBoss) {
        displayHero(playerArr);
        
        int chooseCharacter;
        chooseCharacter = scanner.nextInt();
        chooseCharacter = chooseCharacter - 1;
        
        Player choosenCharacter = playerArr.get(chooseCharacter);
        BattleLog myBattleLog = new ConsoleBattleLog();
        bigBoss.registerBattleLog(myBattleLog);

        bigBoss.onDamageApplied(choosenCharacter);

        bigBoss.getReport().playerHitback(choosenCharacter, bigBoss.getDamageReductionFromBoss());

        bigBoss.getReport().reportBattle(choosenCharacter, bigBoss.getDamageTakenFromBoss(), bigBoss.getHitPointBoss());
        
    }

    public static void main(String[] args) {
        ArrayList<Player> playerArr = new ArrayList<>();
        BigBoss bigBoss = new BigBoss(10000, 10, 0);
        seedPlayer(playerArr);

        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
        while (programRunning) {
            int pilihan; 
            viewMenu();
            System.out.print("pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    addPlayer(playerArr, scanner); break;
                case 2:
                    hitBoss(playerArr, scanner, bigBoss);
                    break;
                case 3:
                    programRunning = false;
            }

        }
        scanner.close();
    }

}
