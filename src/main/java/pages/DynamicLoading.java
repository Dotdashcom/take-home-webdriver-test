package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading {
    public DynamicLoading(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button")
    WebElement startButton;
    @FindBy(xpath = "//h4[.='Hello World!']")
    WebElement message;

    public void pressStart(WebDriver driver) {
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorldMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

    }

    public String isTextDisplayed() {
        return message.getText();
    }
}
