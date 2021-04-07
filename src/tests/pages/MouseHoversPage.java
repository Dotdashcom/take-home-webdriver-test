package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MouseHoversPage {

    public WebDriver driver;

    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> figures;

    @FindBy(xpath = "//h5[contains(text(),'name: user')]")
    public WebElement text_username;

    @FindBy(xpath = "//a[contains(text(),'View profile')]")
    public WebElement text_ViewProfile;


    public MouseHoversPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyMousehoberText(){
        Actions action = new Actions(driver);
        for(WebElement ele : figures){
            action.moveToElement(ele).build().perform();
            Assert.assertTrue(text_username.isDisplayed()&&text_ViewProfile.isDisplayed(),"additional info not displayed on this hover.");
        }
    }

}
