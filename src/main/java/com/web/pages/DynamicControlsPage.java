package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class DynamicControlsPage extends TestBase{

    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    WebElement rmvBtn;
    @FindBy(xpath = "//*[@id='checkbox']")
    WebElement checbox;

    @FindBy(xpath = "//p[@id='message']")
    WebElement txtmsg;

    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    WebElement addBtn;
    @FindBy(xpath = "//*[@id='checkbox-example']/div[1]\n")
    WebElement checkboxBack;
    @FindBy(xpath = "//*[@id='input-example']/button\n")
    WebElement enableBtn;
    @FindBy(xpath = "//*[@id='input-example']/input")
    WebElement inputField;
    @FindBy(xpath = "//*[@id='input-example']/button")
    WebElement disableBtn;



    public DynamicControlsPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickRemoveBtn()
    {
        rmvBtn.click();
    }


    public boolean Checkbox(){
        return checbox.isDisplayed();
    }

    public void clickAddBtn()
    {
        addBtn.click();
    }

    public WebElement newCheckbox(){
        return checkboxBack;
    }

    public void clickEnableBtn()
    {
        enableBtn.click();
    }
    public WebElement textBox()
    {
        return inputField;
    }

    public void clickDisableBtn()
    {
        disableBtn.click();
    }

    public WebElement getDynamicElement()
    {
        return txtmsg;
    }

}