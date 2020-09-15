package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverWrapper;

public class FramePage {

    WebDriver driver;

    public FramePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text() ='iFrame']")
    WebElement iframe;

    public void clickIframe(){ iframe.click(); }
}
