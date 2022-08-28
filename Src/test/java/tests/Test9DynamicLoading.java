package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test9DynamicLoading extends chromedriver {

    @Test
    public void Test9DynamicLoading() {
        String url = "http://localhost:7080/dynamic_loading/2";
        driver.get(url);

        By startButtonXpath = By.xpath("//div[@id='start']/button");
        By loadingBarXpath = By.xpath("//div[@id='loading']");
        By finishedTitleXpath = By.xpath("//div[@id='finish']/h4");

        WebDriverWait wait = new WebDriverWait(driver,15);

        WebElement startButton = driver.findElement(startButtonXpath);
        startButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBarXpath));
        WebElement finishedTitle = driver.findElement(finishedTitleXpath);
        Assert.assertTrue(finishedTitle.isDisplayed());
    }

}