package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GameArithmeticProgression {
    private static final Engine ENGINE = new Engine();

    public static void buildArithmeticProgression() {
        String[][] roundsData = generateRoundsData();
        ENGINE.runGame("What number is missing in the progression?", roundsData);
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[Engine.ROUNDS_FOR_WIN][2];
        for (int i = 0; i < Engine.ROUNDS_FOR_WIN; i++) {
            String[] progressionData = makeProgression();
            roundsData[i][0] = progressionData[0];
            roundsData[i][1] = progressionData[1];
        }
        return roundsData;
    }

    private static String[] makeProgression() {
        int firstNumber = Utils.getRandomNumber(Engine.MAX_RANDOM_NUMBER) + 1;
        int difference = Utils.getRandomNumber(Engine.MAX_DIFFERENCE) + 1;
        int numbers = Utils.getRandomNumber(Engine.MAX_NUMBERS - Engine.MIN_NUMBERS + 1) + Engine.MIN_NUMBERS;
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
        return new String[]{question, String.valueOf(hiddenNumber)};
    }
}

