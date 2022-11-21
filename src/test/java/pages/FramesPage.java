package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class FramesPage extends BasePage {

    WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Nested Frames')]")
    public WebElement nestedFramesOption;

    @FindBy(xpath = "//a[contains(text(),'iFrame')]")
    public WebElement iFramesOption;

    @FindBy(id = "mce_0_ifr")
    public WebElement iFrame;

    @FindBy(xpath = "html/body/p")
    public WebElement inputOnFrame;

    @FindBy(xpath = "//button[@class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']")
    public WebElement closeButton;

    public void clickOnNestedFrames() {
        waitForElement(nestedFramesOption);
        nestedFramesOption.click();
    }

    public void clickOniFrames() {
        waitForElement(iFramesOption);
        iFramesOption.click();
    }

    public void closeNotification() {
        waitForElement(closeButton);
        closeButton.click();
    }

    public void typeOnFrame(String message) {
        waitForElement(iFrame);
        driver.switchTo().frame("mce_0_ifr");
        inputOnFrame.click();
        cleanTextArea(inputOnFrame);
        inputOnFrame.sendKeys(message);
    }

    public void assertMessageOniFrameIs(String message) {
        Assert.assertEquals(inputOnFrame.getText(), message);
    }
}
