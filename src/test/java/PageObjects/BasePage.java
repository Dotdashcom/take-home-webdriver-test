package PageObjects;

import org.openqa.selenium.support.PageFactory;

import Utilities.Driver;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
