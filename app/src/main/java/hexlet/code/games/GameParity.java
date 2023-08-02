package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class GameParity {
    private static final Random RANDOM = new Random();

    public static void gameParity() {
        Cli.acquaintance();

        Engine.task("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.setRound(0);

        while (Engine.getRound() < Engine.getRoundsForWin()) {
            int question = RANDOM.nextInt(Engine.MAX_RANDOM_NUMBER);

            Engine.question();
            System.out.println(question);

            Engine.userAnswer();
            String answer = Engine.getScanner().nextLine().toLowerCase();

            boolean correct = isParity(question, answer);

            if (correct) {
                Engine.correctAnswerMessage();
                Engine.setRound(Engine.getRound() + 1);
            } else {
                Engine.wrongAnswerMessage(answer, correctAnswer(question));
                return;
            }
        }
        Engine.congratulations();
    }

    private static boolean isParity(int number, String answer) {
        return number % 2 == 0 && answer.equals("yes") || number % 2 != 0 && answer.equals("no");
    }

    private static String correctAnswer(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
