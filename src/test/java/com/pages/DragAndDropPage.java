package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BaseClass {

    public DragAndDropPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, using =  "column-a")
    public WebElement _dragElement;

    @FindBy(how = How.ID, using =  "column-b")
    public WebElement _dropElement;

    @FindBy(how = How.XPATH, using =  "//div[@id='columns']/div[1]/header")
    public WebElement _dragElementText;

    @FindBy(how = How.XPATH, using =  "//div[@id='columns']/div[2]/header")
    public WebElement _dropElementText;

    public String GetDragElementText(){
        return _dragElementText.getText();
    }
    public String GetDropElementText(){
        return _dropElementText.getText();
    }
}
