package TakeHome.pages;

import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DynamicContentPage extends BasePage {

    public DynamicContentPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@class='large-10 columns']")
    private List<WebElement> messages;

    @FindBy(xpath = "//*[@href='/dynamic_content?with_content=static']")
    private WebElement staticKey;

    public boolean verifyMessage1Changes(){
        String message=messages.get(0).getText();
        Driver.get().navigate().refresh();
        String newMessage=messages.get(0).getText();

        return !message.equals(newMessage);
    }

    public boolean verifyMessage2Changes(){
        String message=messages.get(1).getText();
        Driver.get().navigate().refresh();
        String newMessage=messages.get(1).getText();

        return !message.equals(newMessage);
    }

    public boolean verifyMessage3Changes(){
        String message=messages.get(2).getText();
        Driver.get().navigate().refresh();
        String newMessage=messages.get(2).getText();

        return !message.equals(newMessage);
    }

    public boolean verifyTopTwoMessagesRemainAfterStaticClick(){
        staticKey.click();
        String message1=messages.get(0).getText();
        String message2=messages.get(1).getText();
        String message3 = messages.get(2).getText();

        Driver.get().navigate().refresh();

        return message1.equals(messages.get(0).getText()) && message2.equals(messages.get(1).getText()) &&
                !message2.equals(messages.get(2).getText());
    }

}