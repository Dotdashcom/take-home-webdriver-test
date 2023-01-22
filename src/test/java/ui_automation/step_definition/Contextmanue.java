package ui_automation.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.ContextMenuPage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Contextmanue {


    WebDriver driver = Driver.getDriver();
    ContextMenuPage contextMenuPage = new ContextMenuPage(driver);

    @Given("user navigate to the check menu URL")
    public void user_navigate_to_the_check_menu_URL() {
       driver = Driver.getDriver();
       String contextURl = (ConfigurationReder.getProperties("ui-config.properties","ContextMenuURL"));
       driver.get(contextURl);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("user right click on the contextmenu")
    public void user_right_click_on_the_contextmenu() {
      Actions actions = new Actions(driver);
      actions.contextClick(contextMenuPage.contextmenu).perform();
    }

    @Then("User validate message on the alert then click Ok")
    public void user_validate_message_on_the_alert_then_click_Ok() {

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(expectedAlertText,actualAlertText);
        driver.switchTo().alert().accept();


    }

    @Then("User close driver")
    public void user_close_driver() {
        Driver.closeDriver();
    }
}
