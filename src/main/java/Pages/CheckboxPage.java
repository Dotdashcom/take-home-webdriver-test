package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class CheckboxPage {
    public WebDriver driver;
    public Helpers helpers;

    public CheckboxPage(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    public By input_checkbox_1 = By.xpath("//input[@type=\"checkbox\"][1]");
    public By input_checkbox_2 = By.xpath("//input[@type=\"checkbox\"][2]");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToCheckboxPage(){
        driver.navigate().to(driver.getCurrentUrl()+"checkboxes ");
    }
    public void Clicking_Successful(){

        helpers.Click(input_checkbox_1);
        helpers.Click(input_checkbox_2);

    }
    public void AssertState() {
        AssertJUnit.assertEquals("Checkbox is not checked", true, Boolean.parseBoolean(helpers.getAttribute(input_checkbox_1, "checked")));
        AssertJUnit.assertEquals("Checkbox is checked", false, Boolean.parseBoolean(helpers.getAttribute(input_checkbox_2, "checked")));


    }
}
