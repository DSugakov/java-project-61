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
                GameParity.buildGameParity();
                break;
            case MenuOptions.CALC:
                GameCalculator.gameCalculator();
                break;
            case MenuOptions.GCD:
                GameNod.buildGameNod();
                break;
            case MenuOptions.PROGRESSION:
                GameArithmeticProgression.buildArithmeticProgression();
                break;
            case MenuOptions.PRIME:
                GamePrimeNumber.buildGamePrimeNumber();
                break;
            case MenuOptions.EXIT:
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}

