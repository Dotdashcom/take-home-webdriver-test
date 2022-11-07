package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContextMenuPage {

    public WebDriver driver;

    public ContextMenuPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "hot-spot")
    private WebElement squareContext;


public void contextClickSquareContex(){

    Helpers.ContextClickElement(squareContext);

}


    public boolean ValidateAlert(String text){

        return driver.switchTo().alert().getText().contains(text);

    }

}
