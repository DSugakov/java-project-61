package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void acquaintance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String name = scanner.nextLine();
        Engine.setUserName(name);
        System.out.println("Hello, " + name + "!");
    }
}
