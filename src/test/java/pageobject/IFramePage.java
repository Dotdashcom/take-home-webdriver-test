package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class IFramePage extends BasePage {

    @FindBy(id = "mce_0_ifr")
    private WebElement iFrame;

    @FindBy(id = "tinymce")
    private WebElement content;


    public IFramePage(WebDriver driver) {
        super(driver, EndPointPath.IFRAME);

    }

    public void typeATextInIFrame(String text) {
        driver.switchTo().frame(iFrame);
        content.clear();
        content.sendKeys(text);
    }

    public boolean verifyTextInIFrame(String text) {
        return content.getText().equals(text);
    }




}
