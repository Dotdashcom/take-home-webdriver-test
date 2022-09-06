package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class DynamicContentPage extends TestBase {
    WebDriver driver = TestBase.getInstance().getDriver();
    @FindBy(css = "div.example>:nth-child(3) > a")
    WebElement clickHere;
    @FindBy(css = "div#content>div.row:nth-of-type(3) > div:nth-child(2)")
    WebElement dynamicContent;

    public DynamicContentPage() {
        PageFactory.initElements(driver, this);
    }

    public void refreshContent() {
        clickHere.click();
    }

    public String dynamicContent() {
        return dynamicContent.getText();
    }

}
