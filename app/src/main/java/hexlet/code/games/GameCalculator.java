package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class GameCalculator {
    private static final Random RANDOM = new Random();
    public static final String[] OPERATORS = {"+", "-", "*"};

    public static void gameCalculator() {
        Cli.acquaintance();

        Engine.setRound(0);

        String[][] roundsData = generateRoundsData();

        Engine.runGame("What is the result of the expression?", roundsData);

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

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[Engine.getRoundsForWin()][2];

        for (int i = 0; i < Engine.getRoundsForWin(); i++) {
            int number1 = RANDOM.nextInt(Engine.MAX_RANDOM_NUMBER);
            int number2 = RANDOM.nextInt(Engine.MAX_RANDOM_NUMBER);
            int operatorIndex = RANDOM.nextInt(OPERATORS.length);

            String question = number1 + " " + OPERATORS[operatorIndex] + " " + number2;
            int correctAnswer = calculate(number1, number2, OPERATORS[operatorIndex]);

            roundsData[i][0] = question;
            roundsData[i][1] = String.valueOf(correctAnswer);
        }

        return roundsData;
    }
}
