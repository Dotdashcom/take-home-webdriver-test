package com.new_york_remote.pages;

import com.new_york_remote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage {
    public MouseHoverPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> images;
    @FindBy(xpath = "(//h5)[1]")
    public WebElement texts1;
    @FindBy(xpath = "(//h5)[2]")
    public WebElement texts2;
    @FindBy(xpath = "(//h5)[3]")
    public WebElement texts3;
}
