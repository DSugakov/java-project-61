package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import java.util.Scanner;

public class GamePrimeNumber {
    public static void gamePrimeNumber() {
        Scanner scanner = new Scanner(System.in);

        Cli.acquaintance();
        Engine.task("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Engine.setRound(0);
        while (Engine.getRound() < Engine.getRoundsToWin()) {
            int number = (int) (Math.random() * 100) + 1;

            Engine.question();
            System.out.println(number);

            Engine.userAnswer();
            String userAnswer = scanner.nextLine().toLowerCase();

            if (isPrime(number).equals(userAnswer)) {
                Engine.correctAnswerMessage();
                Engine.setRound(Engine.getRound() + 1);
            } else {
                Engine.wrongAnswerMessage(userAnswer, isPrime(number));
                return;
            }
        }
        Engine.congratulations();
    }

    private static String isPrime(int number) {
        if (number < 2) {
            return "no";
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
