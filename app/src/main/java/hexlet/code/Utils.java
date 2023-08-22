package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    public static int getRandomNumber(int number) {
        return RANDOM.nextInt(number);
    }
}
