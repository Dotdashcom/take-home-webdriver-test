package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPageObject extends BasePageObject {
    @FindBy(css = "div h3")
    private WebElement text;

    public NewWindowPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public String getText() {
        return text.getText();
    }
}
