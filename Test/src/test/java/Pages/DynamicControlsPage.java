package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends PageBase {

    @FindBy(xpath = "//button[@type='button']")
    WebElement removeButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;

    @FindBy(xpath = "//p[@id='message']")
    WebElement message;

    public String getMessage(){
        BrowserUtils.click(checkBox);
        BrowserUtils.click(removeButton);
        return BrowserUtils.getElementText(message);
    }

}
