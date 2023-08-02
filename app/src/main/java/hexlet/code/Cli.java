package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final Engine ENGINE = new Engine();

    public static void acquaintance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String name = scanner.nextLine();
        ENGINE.setUserName(name);
        System.out.println("Hello, " + name + "!");
    }
}
