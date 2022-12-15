import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DynamicContentPage extends PageObject
{
    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]")
    public WebElement content;
    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }
    public void dynamicContent()
    {
        String Content_beforeRefresh = content.getText();
        for (int i = 0; i<5; i++)
        {
            driver.navigate().refresh();
            String Content_AfterRefresh = content.getText();
            Assert.assertTrue(!Content_AfterRefresh.equals(Content_beforeRefresh));
        }
    }

}
