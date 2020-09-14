package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends BasePage{

    @FindBy(id = "mce_0_ifr")
    WebElement iFrame;

    @FindBy(xpath = "//body[@id='tinymce']")
    WebElement iFrameText;

    public IFramePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testIframe(WebDriver driver, String text) {
        driver.switchTo().frame(iFrame);
        iFrameText.clear();
        iFrameText.sendKeys(text);
        String frameText = iFrameText.getText();
        if (frameText.contains(text)) {
            return true;
        }
        return false;
    }
}
