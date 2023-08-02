package hexlet.code;

import hexlet.code.games.GameCalculator;
import hexlet.code.games.GameParity;
import hexlet.code.games.GameNod;
import hexlet.code.games.GameArithmeticProgression;
import hexlet.code.games.GamePrimeNumber;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuOptions.printMenu();

        int input = scanner.nextInt();
        System.out.println("Your choice: " + input);
        switch (input) {
            case MenuOptions.GREET:
                Cli.acquaintance();
                break;
            case MenuOptions.EVEN:
                GameParity.gameParity();
                break;
            case MenuOptions.CALC:
                GameCalculator.gameCalculator();
                break;
            case MenuOptions.GCD:
                GameNod.gameNod();
                break;
            case MenuOptions.PROGRESSION:
                GameArithmeticProgression.arithmeticProgression();
                break;
            case MenuOptions.PRIME:
                GamePrimeNumber.gamePrimeNumber();
                break;
            case MenuOptions.EXIT:
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}

