package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class GameCalculator {
    static Random random = new Random();
    public static void gameCalculator() {
        Scanner scanner = new Scanner(System.in);

        Cli.acquaintance();

        Engine.task("What is the result of the expression?");
        Engine.round = 0;

        while (Engine.round < Engine.roundsForWin) {
            int firstNumber = random.nextInt(100);
            int secondNumber = random.nextInt(100);

            String operator = getRandomOperator();
            Engine.question();
            System.out.println(firstNumber + " " + operator + " " + secondNumber);

            int correctAnswer = getCorrectAnswer(firstNumber, secondNumber, operator);

            Engine.userAnswer();
            int answer = scanner.nextInt();

            if (correctAnswer == answer) {
                Engine.correctAnswerMessage();
                Engine.round++;
            } else {
                Engine.wrongAnswerMessage(String.valueOf(answer), String.valueOf(correctAnswer));
                return;
            }
        }
        Engine.congratulations();
    }
    public static String getRandomOperator() {
        int operator = random.nextInt(3) + 1;
        switch (operator) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
    public static int getCorrectAnswer(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            default:
                return -1;
        }
    }
}
