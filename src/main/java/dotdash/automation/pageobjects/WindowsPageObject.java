package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class WindowsPageObject extends BasePageObject {
    @FindBy(linkText = "Click Here")
    private WebElement clickHere;

    public WindowsPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    public NewWindowPageObject clickHere() {
        clickHere.click();
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new NewWindowPageObject(driver);
    }

}
