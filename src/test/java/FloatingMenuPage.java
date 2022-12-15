import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.security.PublicKey;

public class FloatingMenuPage extends PageObject{
    @FindBy(id = "menu")
    public WebElement floating_menu;
    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    public void floatingmenu()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        Assert.assertTrue(floating_menu.isDisplayed());

    }
}
