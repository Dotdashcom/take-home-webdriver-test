package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage extends PageObject {

    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement startButton;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void clickStartButton() {
        startButton.click();
    }

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        return driver.findElement(By.id("finish")).getText();
    }
}
