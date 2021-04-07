package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OptionSelectPage {

    public WebDriver driver;

    @FindBy(id = "dropdown")
    public WebElement dropDown;

    public OptionSelectPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void verifyOptionsSelection(){
        if(dropDown.isDisplayed()){
            Select options = new Select(dropDown);
            options.selectByValue("Option 1");
            Assert.assertTrue(dropDown.getAttribute("text").equalsIgnoreCase("Option 1"),"Option 1 not selected as expected");
            options.selectByValue("Option 2");
            Assert.assertTrue(dropDown.getAttribute("text").equalsIgnoreCase("Option 2"),"Option 2 not selected as expected");
        }
    }

}
