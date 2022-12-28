package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    public DynamicControlsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Dynamic Controls")
    WebElement dynamicControlsButton;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    WebElement removeButton;

    @FindBy(xpath = "//p[@id='message']")
    WebElement message;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addButton;

    @FindBy(xpath = "//button[contains(text(),'Enable')]")
    WebElement enableButton;
    @FindBy(xpath = "//button[contains(text(),'Disable')]")
    WebElement disableButton;


    public void clickDynamicControlsButton(){
        dynamicControlsButton.click();
    }

    public void clickRemoveButton(){
        removeButton.click();
    }

   public String getMessage(WebDriver driver){
        BrowserUtils.waitForVisibility(driver,message);
        return BrowserUtils.getText(message);
   }

   public void clickAddButton(){
        addButton.click();
   }
   public void clickEnableButton(){
        enableButton.click();
   }
   public  void clickDisableButton(){
        disableButton.click();
   }




}
