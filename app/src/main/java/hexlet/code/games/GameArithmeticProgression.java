package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;


public class GameArithmeticProgression {

    public static void buildArithmeticProgression() {
        Cli.acquaintance();

        Engine.setRound(0);

        String[][] roundsData = generateRoundsData();

        Engine.runGame("What number is missing in the progression?", roundsData);

        Engine.congratulations();
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[Engine.getRoundsForWin()][2];

        for (int i = 0; i < Engine.getRoundsForWin(); i++) {
            int firstNumber = Utils.getRandomNumber(Engine.MAX_RANDOM_NUMBER) + 1;
            int difference = Utils.getRandomNumber(Engine.MAX_DIFFERENCE) + 1;
            int numbers = Utils.getRandomNumber(Engine.MAX_NUMBERS - Engine.MIN_NUMBERS + 1) + Engine.MIN_NUMBERS;
            int[] progression = new int[numbers];

            int hiddenIndex = Utils.getRandomNumber(numbers);
            int hiddenNumber = 0;

            StringBuilder questionBuilder = new StringBuilder();

            for (int j = 0; j < numbers; j++) {
                if (j == hiddenIndex) {
                    progression[j] = -1;
                    hiddenNumber = firstNumber + j * difference;
                    questionBuilder.append(".. ");
                } else {
                    progression[j] = firstNumber + j * difference;
                    questionBuilder.append(progression[j]).append(" ");
                }
            }

            String question = questionBuilder.toString().trim();
            roundsData[i][0] = question;
            roundsData[i][1] = String.valueOf(hiddenNumber);
        }

        return roundsData;
    }
}
