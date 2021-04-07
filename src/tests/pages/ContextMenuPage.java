package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ContextMenuPage {

    public WebDriver driver;

    @FindBy(id = "hot-spot")
    public WebElement box_hotSpot;

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyContextMenuAlert(){
        if(box_hotSpot.isDisplayed()){
            Actions actions = new Actions(driver);
            actions.contextClick(box_hotSpot).perform();
            Assert.assertTrue(driver.switchTo().alert().getText().contains("You selected a context menu"),"Alert message not matched");
        }

    }

}
