package automationexersice.helper;

import org.apache.commons.lang3.RandomStringUtils;

public class EmailHelper {
    public static String getRandomEmail(int length, boolean useLetters, boolean useNumbers){
        String generatedEmail = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedEmail+"@gmail.com";
    }


}
