package com.Pages;

import com.BaseTest.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingRepository extends TestEngine {

    //parameterized constructor
    public DynamicLoadingRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Start']")
    public WebElement _startButton;

    @FindBy(how = How.XPATH, using = "//h4[text()='Hello World!']")
    public WebElement _helloWorldText;

    public void ClickStartBtn(){
        _startButton.click();
    }

    public boolean IsHelloWorldDisplayed(){
       return _helloWorldText.isDisplayed();
    }
}
