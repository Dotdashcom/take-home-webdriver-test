package Utility;

import org.openqa.selenium.WebDriver;

public class StringUtils {

    public static String removeWhiteSpace(String text) {
        return text.trim().replaceAll("\n", "");
    }
}
