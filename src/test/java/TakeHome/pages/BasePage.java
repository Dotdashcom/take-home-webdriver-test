package TakeHome.pages;


import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    /* Designed to store common elements and actions in the dashboard/base page

     */

    @FindBy(linkText = "Checkboxes")
    protected WebElement checkBoxLink;
}