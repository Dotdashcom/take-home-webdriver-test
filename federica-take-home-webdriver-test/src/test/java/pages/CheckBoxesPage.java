package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CheckBoxesPage {
    public CheckBoxesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//form/input[1]")
    public WebElement boxOne;

    @FindBy(xpath = "//form/input[2]")
    public WebElement boxTwo;

}
