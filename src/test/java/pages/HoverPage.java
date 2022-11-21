package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HoverPage extends BasePage {

    WebDriver driver;

    public HoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='User Avatar']")
    public List<WebElement> pictures;

    @FindBy(css = "div.figcaption")
    public List<WebElement> userData;

    public void hoverAllPicturesAndCheckMessage() {
        for (WebElement element : pictures) {
            hoverElement(element);
            Assert.assertTrue(userData.size() > 0);
        }
    }
}
