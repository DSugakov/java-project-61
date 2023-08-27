package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MAX_DIFFERENCE = 10;
    public static final int MIN_NUMBERS = 5;
    public static final int MAX_NUMBERS = 6;
    private static final int ROUNDS_FOR_WIN = 3;
    private int round = 0;
    private String userName; //исправить

    public static Scanner getScanner() {
        return SCANNER;
    }

    public void setRound(int roundNumber) {
        this.round = roundNumber;
    }

    public static int getRoundsForWin() {
        return ROUNDS_FOR_WIN;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void runGame(String rules, String[][] roundsData) {
        System.out.println(rules);

        for (String[] step : roundsData) {
            String question = step[0];
            String correctAnswer = step[1];

            System.out.print("Question: ");
            System.out.println(question);
            System.out.print("Your answer: ");
            String userAnswer = getScanner().nextLine();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", userName);
    }
}
