package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;


public class GamePrimeNumber {

    public static void buildGamePrimeNumber() {
        Cli.acquaintance();

        Engine.setRound(0);

        String[][] roundsData = generateRoundsData();

        Engine.runGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.", roundsData);

        Engine.congratulations();
    }

    private static String[][] generateRoundsData() {
        String[][] roundsData = new String[Engine.getRoundsForWin()][2];

        for (int i = 0; i < Engine.getRoundsForWin(); i++) {
            int number = Utils.getRandomNumber(Engine.MAX_RANDOM_NUMBER) + 1;
            String correctAnswer = Engine.gamePrimeResult(isPrime(number));

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
