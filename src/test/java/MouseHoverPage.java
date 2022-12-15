import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MouseHoverPage extends PageObject{

    @FindBy(className = "figure")
    public List <WebElement> profiles;
    @FindBy(className = "figcaption")
    public List <WebElement> additional_info;
    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }
    public void mousehovering()
    {
        Actions action = new Actions(driver);

        int profile_size = profiles.size();

        for (int i = 0; i< profile_size; i++)
        {
            action.moveToElement(profiles.get(i)).build().perform();
            Assert.assertTrue(additional_info.get(i).isDisplayed());
        }
    }
}
