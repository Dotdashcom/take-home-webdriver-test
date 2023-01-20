package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MouseOverPage {
    public WebDriver driver;
    public Helpers helpers;

    public MouseOverPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By avatar_figures = By.xpath("//div[@class='figure']");

    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToMouseOver() {

        driver.navigate().to(driver.getCurrentUrl() + "hovers");
    }

    public void MouseOver() {

        List<WebElement> avatars = driver.findElements(avatar_figures);
        for(WebElement avatar : avatars) {
            helpers.MouseOverToElement(avatar);
            Assert.assertTrue(avatar.findElement(By.tagName("h5")).isDisplayed());
        }
    }


}
