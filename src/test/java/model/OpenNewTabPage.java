package model;

import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class OpenNewTabPage extends BasePage {

    private static final String WINDOWS_ENDPOINT = "windows";

    @FindBy(css = ".example a")
    private WebElement clickHereLink;

    public OpenNewTabPage(WebDriver driver) {
        super(driver);
    }

    public OpenNewTabPage getOpenNewTabPage() {
        getDriver(WINDOWS_ENDPOINT);

        return this;
    }

    public OpenNewTabPage clickHereLink() {
        clickHereLink.click();

        return this;
    }

    public String getActiveTabHandle() {

        return getDriver().getWindowHandle();
    }

    public List<String> getTabHandlesList() {

        return new ArrayList<>(getDriver().getWindowHandles());
    }
}