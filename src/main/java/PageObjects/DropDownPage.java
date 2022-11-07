package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropDownPage {

    public WebDriver driver;

    public DropDownPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "dropdown")
    private WebElement dropDown;


public void selectOptionByText(String text){

    Helpers.SelectItemFromSelect(dropDown).selectByVisibleText(text);
}
public  boolean validateOptionText(String text){
    return dropDown.getText().contains(text);
}
}
