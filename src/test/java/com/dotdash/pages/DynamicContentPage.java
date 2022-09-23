package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends BasePage {

    public DynamicContentPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="(//div[@class='large-10 columns'])[1]")
    public WebElement firstElement;


}
