package pages;
import com.google.sitebricks.client.Web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IframeSwitchPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id='tinymce']/p")
    public WebElement  text_iFrame;

    public IframeSwitchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyIframeText(){
        driver.switchTo().frame("mce_0_ifr");
        text_iFrame.sendKeys("Hello print");
        Assert.assertTrue(text_iFrame.getAttribute("text").equalsIgnoreCase("hello print"),"Text not displayed as expected");
    }

}
