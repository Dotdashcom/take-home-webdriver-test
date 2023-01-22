package ui_automation.step_definition;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.IFramePage;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class IFrame {

    WebDriver driver = Driver.getDriver();
    IFramePage page  = new IFramePage(driver);

    @Given("User should be able to navigate to Target URL")
    public void user_should_be_able_to_navigate_to_Target_URL() {
        String IFrameURL = (ConfigurationReder.getProperties("ui-config.properties", "IFrameURL"));
        driver.get(IFrameURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Then("user should be able veriffy the message {string} inside editor")
    public void user_should_be_able_veriffy_the_message_inside_editor(String expMsg) {
        driver.switchTo().frame("mce_0_ifr");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.CONTROL,"a").sendKeys(Keys.DELETE).build().perform();
        String realMsg = page.realmsg.getText();
        Assert.assertEquals(expMsg, realMsg);
    }

}
