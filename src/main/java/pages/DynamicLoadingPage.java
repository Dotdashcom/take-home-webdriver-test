package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {
    WebDriver driver;
    String dynamicLoadingUrl = ("http://localhost:7080/dynamic_loading/2");
    String startButtonXpath = "//button[text()='Start']";
    String alertTextXpath = "//div[@id='finish']/h4";

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(dynamicLoadingUrl);
    }

    public void clickStartButton(){
        WebElement startButton = By.xpath(startButtonXpath).findElement(driver);
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(alertTextXpath)));
    }

    public String getAlertText(){
        return driver.findElement(By.xpath(alertTextXpath)).getText();
    }

}
