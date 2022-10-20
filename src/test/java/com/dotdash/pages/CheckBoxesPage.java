package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPage {
//    @FindBy(xpath = "input[@type='checkbox']")
//    public WebElement checkBox;

    public CheckBoxesPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public WebElement checkBoxLocator(String optionName){
        return BrowserFactory.getDriver().findElement(By.xpath("//text()[contains(.,'"+optionName+"')]//preceding-sibling::input[@type='checkbox'][1]"));
    }
}
