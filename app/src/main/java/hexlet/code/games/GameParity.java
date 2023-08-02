package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class GameParity {
    private static final Random random = new Random();

    public static void gameParity() {
        Scanner scanner = new Scanner(System.in);

        Cli.acquaintance();

        Engine.task("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.setRound(0);

        while (Engine.getRound() < Engine.getRoundsToWin()) {
            int question = random.nextInt(100);

            Engine.question();
            System.out.println(question);

            Engine.userAnswer();
            String answer = scanner.nextLine().toLowerCase();

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

    private static boolean isParity(int question, String answer) {
        return question % 2 == 0 && answer.equals("yes") || question % 2 != 0 && answer.equals("no");
    }

    private static String correctAnswer(int question) {
        return question % 2 == 0 ? "yes" : "no";
    }
}
