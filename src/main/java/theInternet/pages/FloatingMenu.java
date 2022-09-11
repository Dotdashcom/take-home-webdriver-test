package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import theInternet.utils.jsExecutor;

public class FloatingMenu {

    public FloatingMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu")
    WebElement menu;

    @FindBy(linkText = "Floating Menu")
    WebElement floatingMenu;

    public void scrollFloatingMenu(WebDriver driver){
        floatingMenu.click();
        jsExecutor.scrollDownWithJS(driver, 4300);
        Assert.assertTrue(menu.isDisplayed());
    }

}
