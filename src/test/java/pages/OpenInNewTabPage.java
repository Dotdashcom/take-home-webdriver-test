package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class OpenInNewTabPage extends BasePage {
    private By clickHereLink = By.linkText("Click Here");
    private By title = By.tagName("h3");

    public OpenInNewTabPage(WebDriver driver) {
        super(driver);
    }

    public void clickLink() {
        wait.until(ExpectedConditions.elementToBeClickable(clickHereLink));
        getElement(clickHereLink).click();
    }

    public void switchToNewWindow() {
        List<String> windowsHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandles.get(1));
    }

    public String getNewWindowText(){
        String text = "empty";
        text = getMessage(title);
        driver.close();
        List<String> windowsHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandles.get(0));
        return text;
    }
}
