package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoverPage extends BasePage {
    @FindBy(css="div[class=\"figure\"] img")
    List<WebElement> images;

    @FindBy(css="div[class=\"figcaption\"] h5")
    List<WebElement> captions;

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    public void hoverImage(int index){
        Actions builder=new Actions(driver);
        builder.moveToElement(images.get(index)).build().perform();
    }

    public String getCaption(int index){
        return captions.get(index).getText();
    }
}
