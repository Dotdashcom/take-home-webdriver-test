package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


public class CheckboxesPage {

    public CheckboxesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//form[@id='checkboxes']//input[@type='checkbox'][1]")
    public WebElement checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']//input[@type='checkbox'][2]")
    public WebElement checkbox2;
}
