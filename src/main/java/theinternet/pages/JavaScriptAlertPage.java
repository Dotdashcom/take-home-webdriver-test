package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertPage extends BasePage{
    public JavaScriptAlertPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'JavaScript Alerts')]")
    public WebElement javascriptAlertPageHeader;
    @FindBy(xpath = "//button[@onclick='jsAlert()'][contains(.,'Click for JS Alert')]")
    public WebElement javascriptAlertPageAlert;
    @FindBy(xpath = "//button[@onclick='jsConfirm()'][contains(.,'Click for JS Confirm')]")
    public WebElement javascriptAlertPageConfirm;
    @FindBy(xpath = "//button[@onclick='jsPrompt()'][contains(.,'Click for JS Prompt')]")
    public WebElement javascriptAlertPagePrompt;
    @FindBy(xpath = "//p[contains(@id,'result')]")
    public WebElement javascriptAlertPageResultText;

    public Boolean validatePageLanding(){
        javascriptAlertPageHeader.isDisplayed();
        javascriptAlertPageAlert.isDisplayed();
        javascriptAlertPageConfirm.isDisplayed();
        javascriptAlertPagePrompt.isDisplayed();
        javascriptAlertPageResultText.isDisplayed();
        return true;
    }
    public String getAlertText() throws InterruptedException {
        javascriptAlertPageAlert.click();
        Thread.sleep(2000);
        String alertText =  driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public String getConfirmText() throws InterruptedException {
        javascriptAlertPageConfirm.click();
        Thread.sleep(2000);
        String alertText =  driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public String typeAndReturnTextPrompt(String text) throws InterruptedException {
        javascriptAlertPagePrompt.click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        return javascriptAlertPageResultText.getText();
    }

}
