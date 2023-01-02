package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JSErrorPage {

    WebDriver driver;

    public JSErrorPage(WebDriver driver)
    {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
