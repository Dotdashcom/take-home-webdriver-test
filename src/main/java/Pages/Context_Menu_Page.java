package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class Context_Menu_Page {
    public WebDriver driver;
    public Helpers helpers;

    public Context_Menu_Page(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    public By context_box_div = By.id("hot-spot");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToContextPage(){
        driver.navigate().to(driver.getCurrentUrl()+"context_menu  ");
    }
    public void RightClicking_Successful(){

        helpers.RightClick(context_box_div);

    }
    public void AssertAlert() {
        String expectedAlertMessage = "You selected a context menu";
        String actualAlertMessage = driver.switchTo().alert().getText();
        AssertJUnit.assertEquals(expectedAlertMessage, actualAlertMessage);
        driver.switchTo().alert().accept();

    }
}
