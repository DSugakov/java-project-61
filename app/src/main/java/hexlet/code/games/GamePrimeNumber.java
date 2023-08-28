package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_RANDOM_NUMBER;


public class GamePrimeNumber {
    static Engine engine = new Engine();

    public static void buildGamePrimeNumber() {
        Cli.acquaintance();

        engine.setRound(0);

        String[][] roundsData = generateRoundsData();

        engine.runGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.", roundsData);

    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[engine.getRoundsForWin()][2];

        for (int i = 0; i < engine.getRoundsForWin(); i++) {
            int number = Utils.getRandomNumber(MAX_RANDOM_NUMBER) + 1;
            String correctAnswer = gamePrimeResult(isPrime(number));

            roundsData[i][0] = String.valueOf(number);
            roundsData[i][1] = correctAnswer;
        }

        return roundsData;
    }

    public static String gamePrimeResult(boolean answer) {
        if (!answer) {
            return "no";
        }
        return "yes";
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
