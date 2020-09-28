package LocalHost.Pages;

import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HoverPage {
    public HoverPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='figure'][1]")
    private WebElement hover1;

    @FindBy(xpath = "//*[@class='figure'][2]")
    private WebElement hover2;

    @FindBy(xpath = "//*[@class='figure'][3]")
    private WebElement hover3;

    @FindBy(xpath = "//*[@href='/users/1']")
    private WebElement info1;

    @FindBy(xpath = "//*[@href='/users/2']")
    private WebElement info2;

    @FindBy(xpath = "//*[@href='/users/3']")
    private WebElement info3;

    public void hoverUser1(){
        BrowserUtils.hover(hover1);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(info1.isDisplayed());

    }

    public void hoverUser2(){
        BrowserUtils.hover(hover2);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(info2.isDisplayed());

    }

    public void hoverUser3(){
        BrowserUtils.hover(hover3);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(info3.isDisplayed());

    }
}
