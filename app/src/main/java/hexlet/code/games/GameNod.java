package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_RANDOM_NUMBER;

public class GameNod {
    private static final Engine ENGINE = new Engine();
    public static void buildGameNod() {
        Cli.acquaintance(ENGINE);

        ENGINE.setRound(0);

        String[][] roundsData = generateRoundsData();

        ENGINE.runGame("Find the greatest common divisor of given numbers.", roundsData);
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[ENGINE.getRoundsForWin()][2];

        for (int i = 0; i < ENGINE.getRoundsForWin(); i++) {
            int firstNumber = Utils.getRandomNumber(MAX_RANDOM_NUMBER) + 1;
            int secondNumber = Utils.getRandomNumber(MAX_RANDOM_NUMBER) + 1;

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
