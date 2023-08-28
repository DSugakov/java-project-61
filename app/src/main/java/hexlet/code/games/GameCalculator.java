package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.MAX_RANDOM_NUMBER;

public class GameCalculator {
    private static final Random RANDOM = new Random();
    private static final String[] MATH_OPERATORS = {"+", "-", "*"};
    static Engine engine = new Engine();

    public static void gameCalculator() {
        Cli.acquaintance();

        engine.setRound(0);

        String[][] roundsData = generateRoundsData();

        engine.runGame("What is the result of the expression?", roundsData);
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

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[engine.getRoundsForWin()][2];

        for (int i = 0; i < engine.getRoundsForWin(); i++) {
            int number1 = RANDOM.nextInt(MAX_RANDOM_NUMBER);
            int number2 = RANDOM.nextInt(MAX_RANDOM_NUMBER);
            int operatorIndex = RANDOM.nextInt(MATH_OPERATORS.length);

            String question = number1 + " " + MATH_OPERATORS[operatorIndex] + " " + number2;
            int correctAnswer = calculate(number1, number2, MATH_OPERATORS[operatorIndex]);

            roundsData[i][0] = question;
            roundsData[i][1] = String.valueOf(correctAnswer);
        }

        return roundsData;
    }
}
