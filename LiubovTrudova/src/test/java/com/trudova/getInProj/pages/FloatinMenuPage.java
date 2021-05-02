package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatinMenuPage extends BasePage {
    public FloatinMenuPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "menu")
    public WebElement menu;

    @FindBy(linkText = "Elemental Selenium")
    public WebElement eSLink;
}
