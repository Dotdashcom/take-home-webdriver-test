package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IframePage {
    public WebDriver driver;
    public Helpers helpers;
    String text_on_iframe = "THIS IS A TEST";

    public IframePage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By iframe_text_edit = By.id("mce_0_ifr");
    public By iframe_body_edit = By.id("tinymce");

    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToIframeMenu() {

        driver.navigate().to(driver.getCurrentUrl() + "iframe");
    }

    public void WriteOnIframe() {

        driver.switchTo().frame(driver.findElement(iframe_text_edit));
        helpers.sendText(iframe_body_edit, text_on_iframe);
    }
    public void AssertFloatingMenuExistence() {

        Assert.assertTrue(helpers.contains_text(helpers.getText(iframe_body_edit),text_on_iframe));

    }

}
