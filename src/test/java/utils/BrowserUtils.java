package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils {
    public static void sleepSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void highlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 2; i++) {
            try {
                if (i == 0) {
                    executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border:3px solid red; background: yellow");
                } else {
                    sleepSeconds(1);
                    executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
