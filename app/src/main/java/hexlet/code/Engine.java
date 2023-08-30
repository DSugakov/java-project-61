package hexlet.code;

import java.util.Scanner;

public class Engine {
    private final Scanner scanner = new Scanner(System.in);
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MAX_DIFFERENCE = 10;
    public static final int MIN_NUMBERS = 5;
    public static final int MAX_NUMBERS = 6;
    private final int roundsForWin = 3;
    private int round = 0;
    private String userName;

    public Scanner getScanner() {
        return scanner;
    }

    public void setRound(int roundNumber) {
        round = roundNumber;
    }

    public int getRoundsForWin() {
        return roundsForWin;
    }

    public void setUserName(String name) {
        userName = name;
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
