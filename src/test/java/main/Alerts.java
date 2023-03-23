package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Constants;

import java.util.List;

public class Alerts extends Constants{

    @Test
    public void alertsPractice() {
        driver.get("http://localhost:7080/javascript_alerts");

        List<WebElement> buttons = driver.findElements(By.xpath("//ul/li/button"));
        WebDriverWait wait = new WebDriverWait(driver, 10);

        buttons.get(0).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        WebElement p = driver.findElement(By.id("result"));
        sa.assertEquals(p.getText(), "You successfuly clicked an alert");

        buttons.get(1).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        p = driver.findElement(By.id("result"));
        sa.assertEquals(p.getText(), "You clicked: Ok");

        buttons.get(2).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        p = driver.findElement(By.id("result"));
        sa.assertEquals(p.getText(), "You entered: Hello");

        sa.assertAll();

    }
}
