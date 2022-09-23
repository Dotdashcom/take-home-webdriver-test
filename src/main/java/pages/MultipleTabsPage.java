package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class MultipleTabsPage extends AbstractWebPage {

    @FindBy(css = "div.example > a")
    protected WebElement clickHereButtonElm;

    @FindBy(css = "div.example > h3")
    protected WebElement windowTitleElm;

    protected String parentWindowHandle;
    protected String newTabHandle;

    public MultipleTabsPage(WebDriver driver) {
        super(driver);
    }

    public void createATab() {
        parentWindowHandle = driver.getWindowHandle();
        clickHereButtonElm.click();

        ArrayList<String> allTabHandles = new ArrayList<>(driver.getWindowHandles());
        for(String temp: allTabHandles) {
            if(!temp.equalsIgnoreCase(parentWindowHandle)) {
                newTabHandle = temp;
                break;
            }
        }
    }

    public void switchToTab(String where) {
        if(where.equalsIgnoreCase("PARENT")) {
            driver.switchTo().window(parentWindowHandle);
        } else if(where.equalsIgnoreCase("CHILD")) {
            driver.switchTo().window(newTabHandle);
        }
    }

    public String getWindowTitle() {
        return windowTitleElm.getText();
    }
}
