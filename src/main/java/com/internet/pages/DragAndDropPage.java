package com.internet.pages;

import com.internet.utils.Proxywrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.internet.base.Baseclass.webdriver;

public class DragAndDropPage extends Page {

    private static final String PAGE_URL = "/download";

    public DragAndDropPage(WebDriver wd, boolean waitForPageToLoad) {
        super(wd, waitForPageToLoad);
    }

    private By columnA = By.cssSelector("#column-a");
    private By columnB = By.cssSelector("#column-b");
    private By headerA = By.xpath("//div[@id='column-a']/header");
    private By headerB = By.xpath("//div[@id='column-b']/header");

    public void dragColumnAtoColumnB() {
        ((Proxywrapper) webdriver).dragAndDrop(columnA, columnB);
    }

    public String getColumnAText() {
        return ((Proxywrapper) webdriver).getText(columnA);
    }

    public String getColumnBText() {
        return ((Proxywrapper) webdriver).getText(columnB);
    }
}