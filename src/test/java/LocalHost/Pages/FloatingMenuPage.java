package LocalHost.Pages;


import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FloatingMenuPage {
    public FloatingMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='scroll large-10 columns large-centered']")
    private WebElement floatingMenu;

    @FindBy(xpath = "//div[@class='example']/h3")
    private WebElement headerText;

    public void verifyMenu(){
        Assert.assertTrue(floatingMenu.isDisplayed());
    }

    public void ScrollMenu(){
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scroll(0,300)");
        BrowserUtils.waitFor(3);

    }
}
