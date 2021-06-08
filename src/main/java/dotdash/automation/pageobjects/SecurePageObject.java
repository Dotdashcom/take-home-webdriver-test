package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SecurePageObject extends BasePageObject {
    @FindBy(id = "flash")
    private WebElement flashMessage;
    @FindBy(className = "subheader")
    private WebElement subheader;

    public SecurePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    public String getFlashMessage() {
        return flashMessage.getText();
    }

    public String getSubHeader() {
        return subheader.getText();
    }

}
