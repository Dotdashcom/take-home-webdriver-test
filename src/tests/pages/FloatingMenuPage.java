package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FloatingMenuPage {

    public WebDriver driver;

    @FindBy(id = "page-footer")
    public WebElement page_Footer;

    @FindBy(id = "menu")
    public WebElement menu;

    public FloatingMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void verifyFloatingMenuDisplay(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", page_Footer);
        Assert.assertTrue(menu.isDisplayed(),"FLoating not displayed as expected");
    }

}
