package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePageObject extends BasePageObject {
    @FindBy(id="mce_0_ifr")
    WebElement iframe;
    @FindBy(css="div[aria-label='Close']")
    WebElement close;
    @FindBy(id="tinymce")
    WebElement body;

    public IFramePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public IFramePageObject enterText(String text){
        getDriver().switchTo().frame(iframe);
        body.clear();
        body.sendKeys(text);
        return this;
    }
    public String getBodyText(){
        return body.getText();
    }
}
