package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SecurePage {

    private WebDriver driver;
    public static String url = "/secure";

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }
}
