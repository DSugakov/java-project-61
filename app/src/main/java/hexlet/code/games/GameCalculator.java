package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class GameCalculator {
    private static final Random RANDOM = new Random();

    public static void gameCalculator() {
        Cli.acquaintance();

        Engine.task("What is the result of the expression?");
        Engine.setRound(0);

        while (Engine.getRound() < Engine.getRoundsForWin()) {
            int number1 = RANDOM.nextInt(Engine.MAX_RANDOM_NUMBER);
            int number2 = RANDOM.nextInt(Engine.MAX_RANDOM_NUMBER);
            int operatorIndex = RANDOM.nextInt(Engine.OPERATORS.length);

            Engine.question();
            System.out.println(number1 + " " + Engine.OPERATORS[operatorIndex] + " " + number2);

            Engine.userAnswer();
            int userAnswer = Engine.getScanner().nextInt();

            int correctAnswer = calculate(number1, number2, Engine.OPERATORS[operatorIndex]);

            if (userAnswer == correctAnswer) {
                Engine.correctAnswerMessage();
                Engine.setRound(Engine.getRound() + 1);
            } else {
                Engine.wrongAnswerMessage(String.valueOf(userAnswer), String.valueOf(correctAnswer));
                return;
            }
        }
        Engine.congratulations();
    }

    private static int calculate(int number1, int number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
