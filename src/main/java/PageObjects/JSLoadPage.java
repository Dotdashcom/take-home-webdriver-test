package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSLoadPage {
    public WebDriver driver;

    public JSLoadPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }





    public boolean validateTextPage(String text) throws InterruptedException {

        return Helpers.GetConsoleLogs(text);
    }


}
