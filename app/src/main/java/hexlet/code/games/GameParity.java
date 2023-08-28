package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_RANDOM_NUMBER;


public class GameParity {
    static Engine engine = new Engine();

    public static void buildGameParity() {
        Cli.acquaintance();

        engine.setRound(0);

        String[][] roundsData = generateRoundsData();

        engine.runGame("Answer 'yes' if the number is even, otherwise answer 'no'.", roundsData);

    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[engine.getRoundsForWin()][2];

        for (int i = 0; i < engine.getRoundsForWin(); i++) {
            int question = Utils.getRandomNumber(MAX_RANDOM_NUMBER);

            String correctAnswer = correctAnswer(question);

            roundsData[i][0] = String.valueOf(question);
            roundsData[i][1] = correctAnswer;
        }

        return roundsData;
    }

    private static String correctAnswer(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
