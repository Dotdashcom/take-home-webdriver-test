package Pages;

import Utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicContentPage extends TestBase {


    public DynamicContentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='content']//div[@class='large-2 columns']//img")
    public
    List<WebElement> listOfIcon;

    @FindBy(xpath = "//div[@id='content']//div[@class='large-10 columns']")
    public
    List<WebElement> listOfDescription;

}