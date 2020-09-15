package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IframePage {

    WebDriver driver;

    public IframePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (id = "mce_0_ifr")
    WebElement iFrame;

    @FindBy (id = "tinymce")
    WebElement iFrameInputField;

    public void writeInIframe(String text){
        driver.switchTo().frame(iFrame);
        iFrameInputField.clear();
        iFrameInputField.sendKeys(text);
        Assert.assertEquals(text, iFrameInputField.getText());
        driver.switchTo().parentFrame();
    }
}
