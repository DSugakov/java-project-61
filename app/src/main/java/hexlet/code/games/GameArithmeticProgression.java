package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class GameArithmeticProgression {
    public static void arithmeticProgression() {
        Scanner scanner = new Scanner(System.in);
        Cli.acquaintance();

        Engine.task("What number is missing in the progression?");
        Engine.setRound(0);

        while (Engine.getRound() < Engine.getRoundsForWin()) {
            int firstNumber = (int) (Math.random() * Engine.MAX_RANDOM_NUMBER) + 1;
            int difference = (int) (Math.random() * Engine.MAX_DIFFERENCE) + 1;
            int numbers = (int) (Math.random() * (Engine.MAX_NUMBERS - Engine.MIN_NUMBERS + 1)) + Engine.MIN_NUMBERS;
            int[] sequence = new int[numbers];
            sequence[0] = firstNumber;

            for (int i = 1; i < numbers; i++) {
                sequence[i] = sequence[i - 1] + difference;
            }

            int hidden = (int) (Math.random() * numbers);
            int hiddenNumber = sequence[hidden];
            sequence[hidden] = -1;

            Engine.question();
            for (int i = 0; i < numbers; i++) {
                if (i == hidden) {
                    System.out.print(".. ");
                } else {
                    System.out.print(sequence[i] + " ");
                }
            }
            System.out.println();
            Engine.userAnswer();
            int userAnswer = scanner.nextInt();

            if (userAnswer == hiddenNumber) {
                Engine.correctAnswerMessage();
                Engine.setRound(Engine.getRound() + 1);
            } else {
                Engine.wrongAnswerMessage(String.valueOf(userAnswer), String.valueOf(hiddenNumber));
                return;
            }
        }
        Engine.congratulations();
    }
}
