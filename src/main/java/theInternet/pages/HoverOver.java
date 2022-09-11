package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HoverOver {

    public HoverOver(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Hovers")
    WebElement hovers;

    @FindBy(xpath = "//img[@src='/img/avatar-blank.jpg']")
    List<WebElement> images;

    @FindBy(tagName = "h5")
    List<WebElement> names;

    public void hoverOver(WebDriver driver){
        hovers.click();
        Actions actions = new Actions(driver);
            for (int i = 0 ; i<names.size() ; i++){
                actions.moveToElement(images.get(i)).perform();
                Assert.assertTrue(names.get(i).isDisplayed());
            }

    }

}
