package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    public WebDriver ldriver;
    @FindBy(id = "dropdown")
    public WebElement drpdown;

    public DropdownPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public void clkdrpdown() {
        drpdown.click();
    }

    public void selOption1() {
        Select selOption1 = new Select(drpdown);
        selOption1.selectByVisibleText("Option 1");
    }

    public void selOption2() {
        Select selOption2 = new Select(drpdown);
        selOption2.selectByVisibleText("Option 2");
    }

    public String getOptionselected() {
        return drpdown.getText();
    }
}
