package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GameNod {
    private static final Engine ENGINE = new Engine();

    public static void buildGameNod() {
        String[][] roundsData = generateRoundsData();
        ENGINE.runGame("Find the greatest common divisor of given numbers.", roundsData);
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[Engine.ROUNDS_FOR_WIN][2];

        for (int i = 0; i < Engine.ROUNDS_FOR_WIN; i++) {
            int firstNumber = Utils.getRandomNumber(Engine.MAX_RANDOM_NUMBER) + 1;
            int secondNumber = Utils.getRandomNumber(Engine.MAX_RANDOM_NUMBER) + 1;
            int correctAnswer = generateGreatestDivisor(firstNumber, secondNumber);

            roundsData[i][0] = firstNumber + " " + secondNumber;
            roundsData[i][1] = String.valueOf(correctAnswer);
        }

        return roundsData;
    }

    private static int generateGreatestDivisor(int firstNumber, int secondNumber) {
        while (secondNumber > 0) {
            int temp = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        return firstNumber;
    }
}
