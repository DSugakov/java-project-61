package hexlet.code;

public class Engine {
    private static int roundNumber;
    private static final int ROUNDS_TO_WIN = 3;
    private static String userName;

    public static void task(String text) {
        System.out.println(text);
    }

    public static void correctAnswerMessage() {
        System.out.println("Correct!");
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + getUserName() + "!");
    }

    public static void wrongAnswerMessage(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'");
        System.out.println("Let's try again, " + getUserName() + "!");
    }

    public static void question() {
        System.out.print("Question: ");
    }

    public static void userAnswer() {
        System.out.print("Your answer: ");
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String name) {
        userName = name;
    }

    public static int getRound() {
        return roundNumber;
    }

    public static void setRound(int roundNumber) {
        Engine.roundNumber = roundNumber;
    }

    public static int getRoundsToWin() {
        return ROUNDS_TO_WIN;
    }
}
