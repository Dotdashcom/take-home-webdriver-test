package pages;

import core.AbstractWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframesPage extends AbstractWebPage {

    @FindBy(css = "body > div:nth-child(4) > div > div > button")
    protected WebElement closeButton;

    @FindBy(css = "#tinymce > p")
    protected WebElement innerTextElm;

    public IframesPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromInnerFrame() {
        driver.switchTo().frame("mce_0_ifr");
        String innerText = innerTextElm.getText();
        driver.switchTo().defaultContent();
        return innerText;
    }

    public void setTextInInnerFrame(String text) {
        closeButton.click();
        driver.switchTo().frame("mce_0_ifr");
        overrideInput(innerTextElm, text);
        driver.switchTo().defaultContent();
    }
}