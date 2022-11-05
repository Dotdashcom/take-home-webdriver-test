package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_03_CheckBoxes_Page {
    public TC_03_CheckBoxes_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement checkboxOne;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement checkboxTwo;

    @FindBy(partialLinkText =  "Checkboxes")
    public WebElement checkbox;
}
