package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

import java.util.Set;

public class OpenInNewTabPage {


    public OpenInNewTabPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "Click Here")
    public WebElement link;






}
