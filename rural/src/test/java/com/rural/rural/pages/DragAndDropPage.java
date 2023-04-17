package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/drag_and_drop
public class DragAndDropPage {
    @FindBy(xpath = "//*[@id='column-a']")
    public WebElement ColumnA;

    @FindBy(xpath = "//*[@id='column-b']")
    public WebElement ColumnB;



    public DragAndDropPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
