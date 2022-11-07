package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxPage {

    public WebDriver driver;

    public CheckboxPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;


public WebElement ValidateCheckbox(int index){

    return checkboxes.get(index);
}
}
