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
        Print.printMenu();

        int input = scanner.nextInt();
        System.out.println("Your choice: " + input);
        switch (input) {
            case 1:
                Cli.acquaintance();
                break;
            case 2:
                GameParity.gameParity();
                break;
            case 3:
                GameCalculator.gameCalculator();
                break;
            case 4:
                GameNod.gameNod();
                break;
            case 5:
                GameArithmeticProgression.arithmeticProgression();
                break;
            case 6:
                GamePrimeNumber.gamePrimeNumber();
                break;
            case 0:
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}

