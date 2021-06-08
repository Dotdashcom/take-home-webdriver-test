package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPageObject extends BasePageObject {
    private By text = By.cssSelector("div h3");
    public NewWindowPageObject(WebDriver driver) {
        super(driver);
    }

    public String getText(){
        return getDriver().findElement(text).getText();
    }
}
