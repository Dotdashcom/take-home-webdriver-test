package takehome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.Driver;

public class DropDownPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    public DropDownPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Dropdown")
    private WebElement dropDownLink;
    @FindBy(id = "dropdown")
    public WebElement dropdown;


    public void selectDropdownOption(){
        wait.until(ExpectedConditions.elementToBeClickable(dropDownLink));
        dropDownLink.click();

    }

}
