package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class GameCalculator {
    private static final Random random = new Random();

    public static void gameCalculator() {
        Scanner scanner = new Scanner(System.in);

        Cli.acquaintance();

        Engine.task("What is the result of the expression?");
        Engine.setRound(0);

        while (Engine.getRound() < Engine.getRoundsToWin()) {
            int firstNumber = random.nextInt(100);
            int secondNumber = random.nextInt(100);

            String operator = getRandomOperator();
            Engine.question();
            System.out.println(firstNumber + " " + operator + " " + secondNumber);

            int correctAnswer = getCorrectAnswer(firstNumber, secondNumber, operator);

            Engine.userAnswer();
            int answer = scanner.nextInt();

            if (correctAnswer == answer) {
                Engine.correctAnswerMessage();
                Engine.setRound(Engine.getRound() + 1);
            } else {
                Engine.wrongAnswerMessage(String.valueOf(answer), String.valueOf(correctAnswer));
                return;
            }
        }
        Engine.congratulations();
    }

    private static String getRandomOperator() {
        int operator = random.nextInt(3) + 1;
        switch (operator) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private static int getCorrectAnswer(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            default:
                return -1;
        }
    }
}
