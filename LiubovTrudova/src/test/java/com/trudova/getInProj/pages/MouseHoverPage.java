package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage extends BasePage {
    public MouseHoverPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> listImg;


    @FindBy(xpath = "//div[@class='figcaption']")
    public List<WebElement> listInfo;
}
