package task.pages;


import org.openqa.selenium.support.PageFactory;
import task.utilities.Driver;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
