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

    private String enterText = "Enter random text";

    public IFramePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void testIframe(WebDriver driver) {
        driver.switchTo().frame(iFrame);
        iFrameText.sendKeys(enterText);
        System.out.println("Entered text into iFrame textfield");

    }
}
