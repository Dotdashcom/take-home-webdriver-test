package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IFramePage {
    public WebDriver driver;

    public IFramePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "mce_0_ifr")
    private WebElement iFrame;

    @FindBy(id = "tinymce")
    private WebElement textEditor;

    @FindBy(xpath = "//a[.='iFrame']")
    private WebElement iFrameButton;



    public void changeToIFrame(){
       Helpers.SwitchIframe(iFrame);

    }
    public void writeTextEditor(String text){
        Helpers.SendText(textEditor,text);
    }

    public boolean validateWrittenText(String text) throws InterruptedException {

       return textEditor.getText().contains(text);
    }

public void clickIFrameButton(){
        Helpers.ClickElement(iFrameButton);
}
}

