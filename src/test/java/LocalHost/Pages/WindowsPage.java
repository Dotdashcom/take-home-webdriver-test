package LocalHost.Pages;

import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WindowsPage {
    public WindowsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@href='/windows/new']")
    private WebElement windowButton;

    public void verifyNewWindow(){
        windowButton.click();
        BrowserUtils.switchToWindow("New Window");
        String handle=Driver.getDriver().getTitle();
        Assert.assertEquals(handle,"New Window");

    }
}
