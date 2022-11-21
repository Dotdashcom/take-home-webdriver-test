package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class FloatingMenuPage extends BasePage {

    WebDriver driver;

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement homeOption;

    @FindBy(xpath = "//a[text()='News']")
    public WebElement newsOption;

    @FindBy(xpath = "//a[text()='Contact']")
    public WebElement contactOption;

    @FindBy(xpath = "//a[text()='About']")
    public WebElement aboutOption;

    public void assertMenuIsShowing() {
        Assert.assertTrue(elementIsDisplayed(homeOption));
        Assert.assertTrue(elementIsDisplayed(newsOption));
        Assert.assertTrue(elementIsDisplayed(contactOption));
        Assert.assertTrue(elementIsDisplayed(aboutOption));
    }
}
