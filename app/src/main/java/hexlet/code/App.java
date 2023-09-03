package hexlet.code;

import hexlet.code.games.GameCalculator;
import hexlet.code.games.GameParity;
import hexlet.code.games.GameNod;
import hexlet.code.games.GameArithmeticProgression;
import hexlet.code.games.GamePrimeNumber;

import java.util.Scanner;

public class App {
    public static final int GREET = 1;
    public static final int EVEN = 2;
    public static final int CALC = 3;
    public static final int GCD = 4;
    public static final int PROGRESSION = 5;
    public static final int PRIME = 6;
    public static final int EXIT = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();

        int input = scanner.nextInt();
        System.out.println("Your choice: " + input);
        switch (input) {
            case GREET:
                Engine engine = new Engine();
                Cli.acquaintance(engine);
                break;
            case EVEN:
                GameParity.buildGameParity();
                break;
            case CALC:
                GameCalculator.gameCalculate();
                break;
            case GCD:
                GameNod.buildGameNod();
                break;
            case PROGRESSION:
                GameArithmeticProgression.buildArithmeticProgression();
                break;
            case PRIME:
                GamePrimeNumber.buildGamePrimeNumber();
                break;
            case EXIT:
                break;
            default:
                System.out.println("Unknown command");
        }
    }
    public static void printMenu() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
    }
}
