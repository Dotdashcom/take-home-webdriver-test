package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage extends BasePage {

    @FindBy(css="#start button")
    WebElement button;

    @FindBy(css="#finish h4")
    WebElement message;

    public int elementTimeout = configReader.getElementTimeout();

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void clickStart(){
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(elementTimeout));
        wait.until(ExpectedConditions.visibilityOf(message));
    }

    public String getMessage(){
        return message.getText();
    }

}
