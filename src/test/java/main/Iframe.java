package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Constants;

public class Iframe extends Constants {

    static String url = "http://localhost:7080/iframe";


    @Test
    public static void testIframe(){
        driver.get(url);

        driver.switchTo().frame(0);

        WebElement textArea = driver.findElement(By.tagName("p"));
        textArea.clear();
        textArea.sendKeys("test content");
        WebElement newTextArea = driver.findElement(By.tagName("p"));
        String testContent = newTextArea.getText();
        sa.assertEquals(testContent, "test content");

        sa.assertAll();


    }
}
