package LocalHost.Pages;

import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class DynamicLoadingPage {
    public DynamicLoadingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='start']/button")
    private WebElement start;

    @FindBy(id = "finish")
    private WebElement message;



    public void ClickStart(){
        start.click();

    }

    public void VerifyMessage(){

        Assert.assertEquals(message.getText(),"Hello World!");
    }
}
