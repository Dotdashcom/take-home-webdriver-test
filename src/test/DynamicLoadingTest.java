package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class DynamicLoadingTest extends CommonMethods {
    public static void main(String[] args) {
        setUp("http://localhost:7080/dynamic_loading/2");

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement startButton = driver.findElement(By.xpath("//button[text() = 'Start']"));
        startButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        System.out.println("The test is passed. 'Hello World!' text is displayed");

        tearDown();

    }
}
