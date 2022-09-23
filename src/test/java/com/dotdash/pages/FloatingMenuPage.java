package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage extends BasePage{


    public FloatingMenuPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//div[contains(@class,'scroll large-10')]")
    public WebElement floatingMenu;


}
