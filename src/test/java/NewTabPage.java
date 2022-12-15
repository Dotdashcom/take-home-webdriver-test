import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class NewTabPage extends PageObject{

    @FindBy(xpath = "//a[@href=\"/windows/new\"]")
    public WebElement link;
    @FindBy(css = ".example")
    public WebElement newWindow_text;

    public NewTabPage(WebDriver driver) {
        super(driver);
    }
    public void openNewTab()
    {
        String currentTab = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        link.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!currentTab.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Assert.assertTrue(newWindow_text.isDisplayed());



    }
}
