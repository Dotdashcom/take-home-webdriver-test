package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class DynamicControlsPage extends BasePage {

    public DynamicControlsPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/dynamic_controls");
    }

    @FindBy(id = "checkbox")
    private WebElement checkboxA;
    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[text()='Enable']")
    private WebElement enableButton;

    @FindBy(css = "form[id='input-example'] input")
    private WebElement inputField;




    public void clickRemoveButton(){
        removeButton.click();
    }

    public void assertCheckboxIsRemoved(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        WebElement message = driver.findElement(By.cssSelector("form[id='checkbox-example'] p[id='message']"));
        Assert.assertFalse(isElementPresent(checkboxA));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("It's gone!", message.getText());
    }

    public void clickAddButton(){
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();
    }

    public void assertCheckboxIsAdded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        WebElement message = driver.findElement(By.cssSelector("form[id='checkbox-example'] p[id='message']"));
        Assert.assertTrue(isElementPresent(checkboxA));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("It's back!", message.getText());
    }

    public void clickEnableButton(){
        enableButton.click();
    }

    public void clickDisableButton(){
        WebElement disableButton = driver.findElement(By.xpath("//button[text()='Disable']"));
        disableButton.click();
    }

    public void assertInputIsEnabled(){
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        WebElement message = driver.findElement(By.cssSelector("form[id='input-example'] p[id='message']"));
        Assert.assertTrue(inputField.isEnabled());
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("It's enabled!", message.getText());
    }

    public void assertInputIsDisabled(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[id='input-example'] input[disabled]")));
        WebElement message = driver.findElement(By.cssSelector("form[id='input-example'] p[id='message']"));
        Assert.assertFalse(inputField.isEnabled());
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals("It's disabled!", message.getText());
    }



}
