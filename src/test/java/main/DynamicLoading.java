package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Constants;

public class DynamicLoading extends Constants {

    @Test
    public void dynamicContent3() {
        driver.get("http://localhost:7080/dynamic_loading/2");
        WebElement button = driver.findElement(By.xpath("//div[@id='start']//button"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        WebElement hello = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        sa.assertEquals(hello.getText().trim(), "Hello World!");
        sa.assertAll();
    }
}
