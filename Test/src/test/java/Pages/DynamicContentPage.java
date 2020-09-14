package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicContentPage extends PageBase {

    @FindBy(xpath = "//div[@class='large-10 columns']")
    List<WebElement> messages;

    public List<String> getMessagesText(){
        return BrowserUtils.getElementsText(messages);
    }
}
