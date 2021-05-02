package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicContentPage extends BasePage{
    public DynamicContentPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='large-10 columns']")
    public List<WebElement> contentList;
}
