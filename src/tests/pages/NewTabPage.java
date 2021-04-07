package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NewTabPage {

    public WebDriver driver;

    @FindBy(linkText = "Click Here")
    public WebElement link_ClickHere;

    @FindBy(xpath = "//h3[text()='New Window']")
    public WebElement text_NewWindow;

    public NewTabPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyNewTabDisplay(){
        link_ClickHere.click();
        List<String> winHandles = new ArrayList<String> (driver.getWindowHandles());
        if(winHandles.size()==2)
            driver.switchTo().window(winHandles.get(1));
        Assert.assertTrue(text_NewWindow.isDisplayed(),"New window text not displayed as expected.");

    }

}
