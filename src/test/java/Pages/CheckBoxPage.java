package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CheckBoxPage {
    public CheckBoxPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//form/input[1]")
    public WebElement checkboxes1;

    @FindBy(xpath = "//form/input[2]")
    public WebElement checkboxes2;



}
