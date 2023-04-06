package com.homewebdriver.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class DynamicContentPage {
    WebDriver driver;
    private static String DYNAMIC_CONTENT_URL="http://localhost:7080/dynamic_content";

    By contentInPage = By.xpath("//div[@class='large-10 columns']");

    public DynamicContentPage(WebDriver driver){

        this.driver=driver;
        driver.get(DYNAMIC_CONTENT_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);

    }
    public List<String> getContentsInPage(){
        List<WebElement> contents = driver.findElements(contentInPage);
        List<String> contentsInPage = null;
        for(WebElement content : contents) {
             contentsInPage = Collections.singletonList(content.getText());
        }
        return contentsInPage;
    }
}
