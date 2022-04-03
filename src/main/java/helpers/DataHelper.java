package helpers;

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
}
