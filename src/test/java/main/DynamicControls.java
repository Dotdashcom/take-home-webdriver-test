package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Constants;

public class DynamicControls extends Constants {

    @Test
    public void dynamicContent2() {
        // Check box section
        driver.get("http://localhost:7080/dynamic_controls");
        WebElement button1 = driver.findElement(By.xpath("//form[@id='checkbox-example']//button"));

        button1.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='checkbox']")));
        int size = driver.findElements(By.xpath("//div[@id='checkbox']")).size();
        sa.assertTrue(size == 0);

        button1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        size = driver.findElements(By.id("checkbox")).size();
        sa.assertTrue(size > 0);

        // Enabled Disabled Section
        WebElement button2 = driver.findElement(By.xpath("//form[@id='input-example']//button"));

        button2.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//input")));
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']//input"));
        sa.assertTrue(input.isEnabled());

        button2.click();
        wait.until((ExpectedCondition<Boolean>) driver -> !input.isEnabled());
        sa.assertFalse(input.isEnabled());

        sa.assertAll();

    }
}
