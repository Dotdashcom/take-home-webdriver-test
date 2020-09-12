package Pages;

import Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.Set;

public class OpenInNewTapPag extends PageBase {

    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement newTap;

    @FindBy(xpath = "//h3")
     WebElement newWindow;

    public void clickingOnNewTap(){
        BrowserUtils.click(newTap);
        BrowserUtils.switchToWindow(newWindow.getText(),"Opening a new window");


    }
}
