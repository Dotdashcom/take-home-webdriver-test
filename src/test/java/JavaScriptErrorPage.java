import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JavaScriptErrorPage extends PageObject{

    @FindBy(xpath = "//body[@onload=\"loadError()\"]")
    public WebElement error_text;
    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
    }
    public void JSError()
    {
        Assert.assertTrue(error_text.isDisplayed());
    }
}
