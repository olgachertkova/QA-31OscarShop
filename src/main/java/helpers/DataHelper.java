package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataHelper {
    public static String generateRandomEmail(int strLen){
        String randomStrings = "";
        Random random = new Random();
        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
        for(int i = 0; i < strLen; i++) {
            word[i] = (char)('a' + random.nextInt(26));
            randomStrings = randomStrings + word[i];
        }
        String randomEmail = randomStrings + "@.com";
        return randomEmail;
    }

    public static String randomNumeric(int strLen) {
        String numStr = "";
        Random random = new Random();
        int i1 = random.nextInt(9) + 1;
        numStr += i1;

        for (int i = 0; i < strLen - 1; i++) {
            int num = random.nextInt(10);
            numStr += num;
        }

        return numStr;
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
