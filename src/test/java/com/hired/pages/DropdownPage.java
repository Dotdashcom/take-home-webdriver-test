package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage {
    public WebDriver driver;
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="dropdown")
    public WebElement dropdown;

    public void selectOption(String text)  {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), text);
    }
}
