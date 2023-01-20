package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FloatingMenuPage {
    public WebDriver driver;
    public Helpers helpers;

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By home_link_a = By.linkText("Home");
    public By news_link_a = By.linkText("News");
    public By contact_link_a = By.linkText("Contact");
    public By about_link_a = By.linkText("About");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToFloatingMenu() {

        driver.navigate().to(driver.getCurrentUrl() + "floating_menu");
    }

    public void ScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }
    public void AssertFloatingMenuExistence() {
    helpers.Click(home_link_a);
    helpers.Click(news_link_a);
    helpers.Click(contact_link_a);
    helpers.Click(about_link_a);

    }

}
