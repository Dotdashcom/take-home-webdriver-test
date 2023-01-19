package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class DropdownPage {
    public WebDriver driver;
    public Helpers helpers;

    public DropdownPage(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    public By dropdown_select = By.id("dropdown");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToDropDown(){
        driver.navigate().to(driver.getCurrentUrl()+"dropdown");
    }
    public void SelectOption(String value){

        helpers.SelectByValue(dropdown_select, value);

    }
    public void AssertOption(String option) {
        AssertJUnit.assertEquals(option, helpers.GetTextSelect(dropdown_select));

    }
}
