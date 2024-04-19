package automationexersisice.helper;

import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperReg {

    public static int getNumberFromString(String text) {

        int number = 0;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            number = Integer.parseInt(matcher.group());
        }
        return number;
    }








}

