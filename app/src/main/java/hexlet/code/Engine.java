package hexlet.code;

public class Engine {
    public static int round;
    public static int roundsForWin = 3;
    static String userName;
    public static void task(String text) {
        System.out.println(text);
    }
    public static void correctAnswerMessage() {
        System.out.println("Correct!");
    }
    public static void congratulations() {
        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }
    public static void wrongAnswerMessage(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "'"
                + " is wrong answer ;(. Correct answer was "
                + "'" + correctAnswer + "'");
        System.out.println("Let's try again, " + Engine.getUserName() + "!");
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
    public void setUserName(String name) {
        userName = name;
    }
}
