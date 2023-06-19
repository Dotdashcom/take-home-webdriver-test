package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DynamicControlsPage {

    private WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    private WebElement removeAddButton;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    private WebElement enableDisableButton;

    @FindBy(xpath = "//p[@id='message']")
    private WebElement message;

    @FindBy(xpath = "//input[@id='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath="//form[@id='input-example']//input[@type='text']")
    private WebElement enableBox;

    public String clickOnRemoveAddButton(){
        removeAddButton.click();
        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }

    public boolean checkBoxExists(){
        return checkBox.isDisplayed();
    }

    public boolean checkEnableBox() {
        return enableBox.isEnabled();
    }

    public void clickOnEnableDisableButton(){
        enableDisableButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(message));
    }
}
