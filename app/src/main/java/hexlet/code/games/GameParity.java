package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GameParity {
    private static final Engine ENGINE = new Engine();

    public static void buildGameParity() {
        String[][] roundsData = generateRoundsData();
        ENGINE.runGame("Answer 'yes' if the number is even, otherwise answer 'no'.", roundsData);
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[Engine.ROUNDS_FOR_WIN][2];

        for (int i = 0; i < Engine.ROUNDS_FOR_WIN; i++) {
            int question = Utils.getRandomNumber(Engine.MAX_RANDOM_NUMBER);
            String correctAnswer = isEven(question) ? "yes" : "no";

            roundsData[i][0] = String.valueOf(question);
            roundsData[i][1] = correctAnswer;
        }

        return roundsData;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
