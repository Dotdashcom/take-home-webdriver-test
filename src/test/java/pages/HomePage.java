package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private By message = By.id("flash");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getHomePageMessage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        return getMessage(message);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
