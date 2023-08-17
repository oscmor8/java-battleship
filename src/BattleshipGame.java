import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame {
    private ArrayList<Battleship> battleships;
    private int guesses;

    public BattleshipGame() {
        battleships = new ArrayList<>();
        guesses = 0;
    }

    public void createBattleships() {
        battleships.add(new Battleship("poniez", "D4"));
        battleships.add(new Battleship("hacqui", "G5"));
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!battleships.isEmpty()) {
            System.out.print("Enter a guess: ");
            String guess = scanner.nextLine().toUpperCase();
            guesses++;

            boolean hit = false;
            Battleship sunkShip = null;

            for (Battleship battleship : battleships) {
                if (battleship.checkGuess(guess)) {
                    hit = true;
                    battleship.sink();
                    sunkShip = battleship;
                    break;
                }
            }

            System.out.println(hit ? "hit" : "miss");

            if (sunkShip != null && sunkShip.isSunk()) {
                battleships.remove(sunkShip);
                System.out.println("Ouch! You sunk " + sunkShip.getName() + " :(");
                System.out.println("Kill");
            }

            if (battleships.isEmpty()) {
                System.out.println("All Startups are dead! Your stock is now worthless,");
                System.out.println("Took you long enough. " + guesses + " guesses.");
            }
        }
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.createBattleships();
        game.play();
    }
}
// battleship



