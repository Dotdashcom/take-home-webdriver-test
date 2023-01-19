package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DynamicLoadingPage {
    public WebDriver driver;
    public Helpers helpers;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    //REMOVE/ADD
    public By start_button = By.xpath("//div[@id='start']//button");
    public By finish_message = By.xpath("//div[@id='finish']");
    public By example_1 = By.linkText("Example 1: Element on page that is hidden");
    public By example_2 = By.linkText("Example 2: Element rendered after the fact");

    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToDynamicLoading() {

        driver.navigate().to(driver.getCurrentUrl() + "dynamic_loading");
    }

    public void Element_on_page_that_is_hidden() {
        helpers.Click(example_1);
        helpers.Click(start_button);
        Assert.assertNotNull(helpers.WaitElementToBePresent(finish_message));

    }

    public void Element_rendered_after_the_fact() {
        helpers.Click(example_2);
        helpers.Click(start_button);
        Assert.assertNotNull(helpers.WaitElementToBePresent(finish_message));
    }


}
