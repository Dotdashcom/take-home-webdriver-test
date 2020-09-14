package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class iFramePage extends PageBase{

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    WebElement frame;
    @FindBy(xpath = "//iframe")
    WebElement textArea;

    public String frameTextCheck(String text){
        return BrowserUtils.enterTextInFrameElement(frame,textArea,text);
    }

}
