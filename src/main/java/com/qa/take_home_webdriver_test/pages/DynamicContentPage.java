package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage extends BasePage {

    // PAGE INITIALIZATION:
    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By IMAGES = By.cssSelector("#content div div img");
    private static final By CONTENT = By.cssSelector("#content div div:nth-child(2)");

    // WEB ELEMENTS:
    private List<WebElement> getImagesList() {
        wait.until(ExpectedConditions.presenceOfElementLocated(IMAGES));
        return driver.findElements(IMAGES);
    }

    private List<WebElement> getContentList() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CONTENT));
        return driver.findElements(CONTENT);
    }

    // METHODS:
    public List<String> imagesList() {
        List<String> attributeList = new ArrayList<>();
        List<WebElement> list = getImagesList();
        for (WebElement s : list) {
            log.info("User receives the list of images. ");
            System.out.println(s.getAttribute("src"));
            attributeList.add(s.getAttribute("src"));
        }
        return attributeList;
    }

    public List<String> contentList() {
        List<String> contentList = new ArrayList<>();
        List<WebElement> list = getContentList();
        for (WebElement s : list) {
            log.info("User receives the list of contents. ");
            System.out.println(s.getText());
            contentList.add(s.getText());
        }
        return contentList;
    }

    public void refreshPage(){
        log.info("User refreshes a web page");
        driver.navigate().refresh();
    }
}



