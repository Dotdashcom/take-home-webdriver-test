package com.homewebdriver.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MouseHoverPage {
    WebDriver driver;

    private static String MOUSE_HOVER_URL="http://localhost:7080/hovers";

    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> images;

    @FindBy(xpath = "//div[@class='figure']/div/h5")
    public List<WebElement> imageContentsList;

    @FindBy(xpath = "//div[@class='figure'][1]/div/a")
    public WebElement viewProfileLink;



    public MouseHoverPage(WebDriver driver){
        this.driver=driver;
        driver.get(MOUSE_HOVER_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public List<String> getContentFromMouseOverImages() {
        Actions actions = new Actions(driver);
        boolean flag =false;
    List<String> imageContents = new ArrayList<>();

        for(WebElement image : images) {
            actions.moveToElement(image);
            actions.moveToElement(viewProfileLink);
        }
        for (WebElement element : imageContentsList){
            actions.moveToElement(element);
            imageContents.add(element.getAttribute("innerText"));
        }
        return imageContents;
    }
}
