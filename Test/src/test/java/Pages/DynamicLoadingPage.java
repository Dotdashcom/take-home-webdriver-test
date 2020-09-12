package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends PageBase {

    @FindBy(xpath = "//*[text()='Start']")
    WebElement stratButton;

    @FindBy(xpath = "//div[@id='finish']/h4")
    WebElement text;

    public String getMessage(){
        BrowserUtils.click(stratButton);
        BrowserUtils.getElementText(text);
        return BrowserUtils.getElementText(text);

    }


}
