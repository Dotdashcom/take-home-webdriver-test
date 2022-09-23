package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasePage{

    public ContextMenuPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "hot-spot")
    public WebElement square;




}
