package org.benjamin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    public static WebDriver startDriver(){
        return new ChromeDriver();
    }
}
