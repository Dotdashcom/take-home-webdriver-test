package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BasePage {
    private By startButton = By.xpath("//button[text()='Start']");
    private By message = By.xpath("//*[@id=\"finish\"]/h4");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public String getMessage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        return driver.findElement(message).getText();
    }

    public void clickStartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(startButton));
        getElement(startButton).click();
    }
}
