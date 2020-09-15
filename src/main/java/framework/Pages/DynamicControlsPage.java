package framework.Pages;

import cucumber.api.java.cs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlsPage {

    WebDriver driver;
    WebDriverWait wait;

    public DynamicControlsPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 5);
        this.driver = driver;
    }

    @FindBy(id = "checkbox")
    WebElement checkbox;

    @FindBy(xpath = "//button[text()='Add']")
    WebElement addButton;

    @FindBy(xpath = "//button[text()='Remove']")
    WebElement removeButton;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(xpath = "//*[@id='input-example']/input")
    WebElement inputText;

    @FindBy(xpath = "//button[text()='Enable']")
    WebElement enableButton;

    @FindBy(xpath = "//button[text()='Disable']")
    WebElement disableButton;

    public void verifyCheckBoxRemove(){
        Assert.assertEquals(true, checkbox.isDisplayed());
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals("It's gone!", message.getText());
        Assert.assertTrue(driver.findElements(By.id("checkbox")).size() == 0);
    }

    public void verifyCheckBoxAdd(){
        addButton.click();
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals("It's back!", message.getText());
        Assert.assertEquals(true,checkbox.isDisplayed());
    }

    public void verifyInputEnabled(){
        Assert.assertEquals(false, inputText.isEnabled());
        enableButton.click();
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals("It's enabled!", message.getText());
        Assert.assertEquals(true,inputText.isEnabled());
    }

    public void verifyInputDisabled(){
        Assert.assertEquals(true, inputText.isEnabled());
        disableButton.click();
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals("It's disabled!", message.getText());
        Assert.assertEquals(false,inputText.isEnabled());
    }
}
