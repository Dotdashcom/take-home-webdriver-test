package LocalHost.Pages;

import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Dynamic_Content_Page {
    public Dynamic_Content_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='large-10 columns']")
    private List<WebElement> messages;

    @FindBy(xpath = "//*[@href='/dynamic_content?with_content=static']")
    private WebElement staticKey;

    public void VerifyMessage1(){
        String message=messages.get(0).getText();
        Driver.getDriver().navigate().refresh();
        String newMessage=messages.get(0).getText();

        if(message.equals(newMessage))
            Assert.fail();
    }

    public void VerifyMessage2(){
        String message=messages.get(1).getText();
        Driver.getDriver().navigate().refresh();
        String newMessage=messages.get(1).getText();

        if(message.equals(newMessage))
            Assert.fail();
    }

    public void VerifyMessage3(){
        String message=messages.get(2).getText();
        Driver.getDriver().navigate().refresh();
        String newMessage=messages.get(2).getText();

        if(message.equals(newMessage))
            Assert.fail();
    }

    public void VerifyStatic(){
        staticKey.click();
        String message1=messages.get(0).getText();
        String message2=messages.get(1).getText();
        Driver.getDriver().navigate().refresh();

        if(!message1.equals(messages.get(0).getText()))
            Assert.fail();
        if(!message2.equals(messages.get(1).getText()))
            Assert.fail();
    }

}
