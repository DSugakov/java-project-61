package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String[] OPERATORS = {"+", "-", "*"};
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MAX_DIFFERENCE = 10;
    public static final int MIN_NUMBERS = 5;
    public static final int MAX_NUMBERS = 6;

    private static int round = 0;
    private static final int roundsForWin = 3;
    private static String userName = "";

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static int getRound() {
        return round;
    }

    public static void setRound(int roundNumber) {
        round = roundNumber;
    }

    public static int getRoundsForWin() {
        return roundsForWin;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String name) {
        userName = name;
    }

    public static void question() {
        System.out.print("Question: ");
    }

    public static void userAnswer() {
        System.out.print("Your answer: ");
    }

    public static void task(String taskDescription) {
        System.out.println(taskDescription);
    }

    public static void correctAnswerMessage() {
        System.out.println("Correct!");
    }

    public static void wrongAnswerMessage(String userAnswer, String correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!%n", userName);
    }

    public static void congratulations() {
        System.out.printf("Congratulations, %s!%n", userName);
    }
}
