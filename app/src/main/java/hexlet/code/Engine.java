package hexlet.code;

import java.util.Scanner;

public class Engine {
    private final Scanner scanner = new Scanner(System.in);
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MAX_DIFFERENCE = 10;
    public static final int MIN_NUMBERS = 5;
    public static final int MAX_NUMBERS = 6;
    public static final int ROUNDS_FOR_WIN = 3;
    private String userName;

    /**
     * Sets the username.
     *
     * @param name The username to set.
     */
    public void setUserName(String name) {
        userName = name;
    }

    /**
     * Runs the game with the provided rules and rounds data.
     *
     * @param rules      The rules of the game.
     * @param roundsData Data for each round.
     */
    public void runGame(String rules, String[][] roundsData) {
        System.out.println(rules);

        System.out.println("May I have your name?");
        String name = scanner.nextLine();
        setUserName(name);
        System.out.println("Hello, " + name + "!");

        for (String[] step : roundsData) {
            String question = step[0];
            String correctAnswer = step[1];

            System.out.print("Question: ");
            System.out.println(question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is the wrong answer ;(. The correct answer was '%s'.%n",
                        userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", userName);
    }
}
