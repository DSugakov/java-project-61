package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GamePrimeNumber {
    private static final Engine ENGINE = new Engine();

    public static void buildGamePrimeNumber() {
        String[][] roundsData = generateRoundsData();
        ENGINE.runGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.", roundsData);
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[Engine.ROUNDS_FOR_WIN][2];

        for (int i = 0; i < Engine.ROUNDS_FOR_WIN; i++) {
            int number = Utils.getRandomNumber(Engine.MAX_RANDOM_NUMBER) + 1;
            String correctAnswer = isPrime(number) ? "yes" : "no";

            roundsData[i][0] = String.valueOf(number);
            roundsData[i][1] = correctAnswer;
        }

        return roundsData;
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
