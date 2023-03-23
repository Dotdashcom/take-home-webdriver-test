package utils;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class Constants {
    public static WebDriver driver;
    public static SoftAssert sa;

    public static int waitTime = 5;

    // Pages
    LoginPage loginPage;

}
