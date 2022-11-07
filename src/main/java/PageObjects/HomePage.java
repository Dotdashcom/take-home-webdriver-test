package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li/a")
    private List<WebElement> mainMenu;



public void clickOptionFromMenu(String text){

    Helpers.SelectElementByTextList(mainMenu,text);
}
}
