package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class GameNod {
    public static void gameNod() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Cli.acquaintance();

        Engine.task("Find the greatest common divisor of given numbers.");
        Engine.setRound(0);

        while (Engine.getRound() < Engine.getRoundsForWin()) {
            int firstNumber = random.nextInt(100);
            int secondNumber = random.nextInt(100);

            Engine.question();
            System.out.println(firstNumber + " " + secondNumber);

            Engine.userAnswer();
            int answer = scanner.nextInt();

            int correctAnswer = correctAnswer(firstNumber, secondNumber);

            if (answer == correctAnswer) {
                Engine.correctAnswerMessage();
                Engine.setRound(Engine.getRound() + 1);
            } else {
                Engine.wrongAnswerMessage(String.valueOf(answer), String.valueOf(correctAnswer));
                return;
            }
        }
        Engine.congratulations();
    }
    public static int correctAnswer(int firstNumber, int secondNumber) {
        while (secondNumber > 0) {
            int temp = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        return firstNumber;
    }
}
