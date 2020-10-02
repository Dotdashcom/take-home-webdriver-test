package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpenNewTabRepository extends TestEngine {

    public OpenNewTabRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Click Here']")
    public WebElement _clickHereBtn;

    @FindBy(how = How.XPATH, using = "//h3[text()='New Window']")
    public WebElement _newWindowTitle;

    public void ClickOnClickHerBtn(){
        _clickHereBtn.click();
    }

    public void SwitchTabs(int tab){
        SeleniumCommonMethods.SwitchBetweenTabs(tab);
    }

    public boolean IsNewTabOpened(){
        return _newWindowTitle.isDisplayed();
    }

}
