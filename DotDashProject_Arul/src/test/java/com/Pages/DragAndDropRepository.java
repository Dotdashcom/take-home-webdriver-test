package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropRepository extends TestEngine {

    //parameterized constructor
    public DragAndDropRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "column-a")
    public WebElement _dragFromLocator;

    @FindBy(how = How.ID, using = "column-b")
    public WebElement _dropToLocator;


    @FindBy(how = How.XPATH, using =  "//div[@id='columns']/div[1]/header")
    public WebElement _dragElementText;

    @FindBy(how = How.XPATH, using =  "//div[@id='columns']/div[2]/header")
    public WebElement _dropElementText;

    public void DragAndDropValidation(){
        SeleniumCommonMethods.DragAndDropMethod(_dragFromLocator,_dropToLocator);
    }

    public boolean IsDragLocatorTextCorrect(){
        return _dragElementText.getText().trim().contains("B");
    }

    public boolean IsDropLocatorTextCorrect(){
        return _dropElementText.getText().trim().contains("A");
    }
}
