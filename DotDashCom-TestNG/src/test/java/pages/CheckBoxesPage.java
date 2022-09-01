package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CheckBoxesPage {
    public CheckBoxesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(tagName = "input")
    public List<WebElement> checkboxes;
}
