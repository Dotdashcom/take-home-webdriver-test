package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class NewTabPage extends TestBase {
    @FindBy(css = "a[href='/windows/new']")
    WebElement clickHereLink;

    public NewTabPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public void clickHereLink() {
        clickHereLink.click();
    }
}
