package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenInNewTabPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), 'Click Here')]")
    WebElement clickHereButton;

    @FindBy(xpath = "//h3[contains(text(), 'New Window')]")
    WebElement newWindowText;

    public OpenInNewTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testOpeningNewPage(WebDriver driver) {
        boolean isSwitched = false;
        clickOnElement(driver, clickHereButton, "Success: Clicked on Click here button",
                "Failed: Unable to click on Click here button");
        switchToChildWindow(driver);
        if (isElementPresent(driver, newWindowText)) {
            isSwitched = true;
        }
        return isSwitched;
    }
}
