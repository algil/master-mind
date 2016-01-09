package common;

import java.util.Random;

/**
 * Created by LENOVO on 09/01/2016.
 */
public final class NumberUtils {

    public static int calculateRandomNumberBetween1And4() {
        Random random = new Random();
        int randomValue = 0;
        try {
            randomValue = random.nextInt(6 - 1) + 1;

            return randomValue;
        } catch(Exception ex) {
            throw ex;
        }
    }
}
