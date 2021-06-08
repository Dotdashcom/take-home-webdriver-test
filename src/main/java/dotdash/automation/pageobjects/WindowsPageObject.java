package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowsPageObject extends BasePageObject {
    private By clickHere = By.linkText("Click Here");

    public WindowsPageObject(WebDriver driver) {
        super(driver);
    }

    public NewWindowPageObject clickHere() {
        getDriver().findElement(clickHere).click();
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new NewWindowPageObject(driver);
    }

}
