package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends BasePage{

    public DynamicControlsPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    public WebElement firstBtn;

    @FindBy(id = "message")
    public WebElement text1;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement secondBtn;

    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement secondBtn2;



}
