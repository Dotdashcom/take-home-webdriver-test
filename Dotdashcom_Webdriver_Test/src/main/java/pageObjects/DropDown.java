package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class DropDown {
    public WebDriver driver;

    public Properties pr;


    public DropDown(WebDriver dr) {
        this.driver = dr;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "dropdown")
    WebElement drpd;



    public WebElement dropdown()
    {
        return drpd;
    }


}