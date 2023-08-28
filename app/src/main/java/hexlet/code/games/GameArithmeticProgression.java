package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class GameArithmeticProgression {
    static Engine engine = new Engine();

    public static void buildArithmeticProgression() {
        Cli.acquaintance();

        engine.setRound(0);

        String[][] roundsData = generateRoundsData();

        engine.runGame("What number is missing in the progression?", roundsData);
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[engine.getRoundsForWin()][2];

        for (int i = 0; i < engine.getRoundsForWin(); i++) {
            int firstNumber = Utils.getRandomNumber(engine.MAX_RANDOM_NUMBER) + 1;
            int difference = Utils.getRandomNumber(engine.MAX_DIFFERENCE) + 1;
            int numbers = Utils.getRandomNumber(engine.MAX_NUMBERS - engine.MIN_NUMBERS + 1) + engine.MIN_NUMBERS;
            String[] progression = new String[numbers];

            int hiddenIndex = Utils.getRandomNumber(numbers);
            int hiddenNumber = firstNumber + hiddenIndex * difference;

            for (int j = 0; j < numbers; j++) {
                if (j == hiddenIndex) {
                    progression[j] = "..";
                } else {
                    progression[j] = String.valueOf(firstNumber + j * difference);
                }
            }

            String question = String.join(" ", progression);
            roundsData[i][0] = question;
            roundsData[i][1] = String.valueOf(hiddenNumber);
        }

        return roundsData;
    }
}
