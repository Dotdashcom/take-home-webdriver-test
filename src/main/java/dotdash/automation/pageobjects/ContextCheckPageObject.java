package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextCheckPageObject extends BasePageObject {
    @FindBy(id = "hot-spot")
    private WebElement context;

    public ContextCheckPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public ContextCheckPageObject rightClickContext() {
        new Actions(getDriver()).contextClick(context).perform();
        return this;
    }

    public String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }
}
