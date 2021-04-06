package TakeHome.pages;

import TakeHome.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends BasePage {

    public IFramePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;

    @FindBy(id = "tinymce")
    private WebElement textBox;


    public void switchFrameAndSendText(){
        Driver.get().switchTo().frame(iframe);
        String str="Hello There!!!";
        textBox.clear();
        textBox.sendKeys(str);
    }

    public String getTextInIframe() {
        return textBox.getText();
    }

}
