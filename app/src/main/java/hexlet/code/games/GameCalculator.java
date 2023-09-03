package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GameCalculator {
    private static final Random RANDOM = new Random();
    private static final String[] MATH_OPERATORS = {"+", "-", "*"};
    private static final Engine ENGINE = new Engine();

    public static void gameCalculate() {
        final String rules = "What is the result of the expression?";
        String[][] roundsData = generateRoundsData(Engine.ROUNDS_FOR_WIN);
        ENGINE.runGame(rules, roundsData);
    }

    private static String[] generateRoundData() {
        int number1 = RANDOM.nextInt(Engine.MAX_RANDOM_NUMBER);
        int number2 = RANDOM.nextInt(Engine.MAX_RANDOM_NUMBER);
        int operatorIndex = RANDOM.nextInt(MATH_OPERATORS.length);

        String question = number1 + " " + MATH_OPERATORS[operatorIndex] + " " + number2;
        int correctAnswer = calculate(number1, number2, MATH_OPERATORS[operatorIndex]);

        return new String[]{question, String.valueOf(correctAnswer)};
    }

    private static String[][] generateRoundsData(int roundsCount) {
        String[][] roundsData = new String[roundsCount][2];

        for (int i = 0; i < roundsCount; i++) {
            roundsData[i] = generateRoundData();
        }

        return roundsData;
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


