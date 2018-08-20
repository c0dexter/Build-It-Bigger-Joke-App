package michaldobrowolski.pl.javajokes.utils;

import java.util.Random;

public class RandomSelector {

    public static int randomInt(int maxValue) {
        Random generator = new Random();
        int randomValue;
        randomValue = generator.nextInt(maxValue) + 1;

        return randomValue;
    }
}
