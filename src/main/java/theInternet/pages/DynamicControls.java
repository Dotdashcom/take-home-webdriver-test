package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DynamicControls {

    public DynamicControls(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Dynamic Controls")
    WebElement dynamicControl;

    @FindBy(id = "checkbox")
    WebElement checkBox;

    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    WebElement removeButton;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    WebElement enableButton;

    @FindBy(xpath = "//button[@onclick='swapCheckbox()']//following::p")
    WebElement removeMessage;

    @FindBy(xpath = "//button[@onclick='swapInput()']//following::p")
    WebElement disableMessage;

    public void checkControls(WebDriver driver){
        dynamicControl.click();
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
        String msgRemove=removeMessage.getText().trim();
        Assert.assertTrue(msgRemove.equals("It's gone!"));

        enableButton.click();
        wait.until(ExpectedConditions.visibilityOf(disableMessage));
        Assert.assertTrue(disableMessage.getText().equals("It's enabled!"));





    }

}
