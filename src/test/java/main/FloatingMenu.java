package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Constants;

public class FloatingMenu extends Constants {

    static String url = "http://localhost:7080/floating_menu";


    @Test
    public static void testFloatingMenu() {
        driver.get(url);

        WebElement menu = driver.findElement(By.xpath("//ul"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        boolean menuDisplayed = menu.isDisplayed();

        sa.assertEquals(menuDisplayed, true);

        sa.assertAll();


    }
}
