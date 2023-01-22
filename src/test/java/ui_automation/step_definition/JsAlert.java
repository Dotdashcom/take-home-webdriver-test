package ui_automation.step_definition;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.CheckBoxesPage;
import ui_automation.utilities.AlertHelper;
import ui_automation.utilities.ConfigurationReder;
import ui_automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.JSAlertPage;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class JsAlert {

    WebDriver driver = Driver.getDriver();
    JSAlertPage page = new JSAlertPage(driver);


    Hooks hooks = new Hooks();

    @Given("User should be able to Navigate to the Js Alert URL")
    public void user_should_be_able_to_Navigate_to_the_Js_Alert_URL() {
        String JsAlertURL = (ConfigurationReder.getProperties("ui-config.properties", "JsAlertURL"));
        driver.get(JsAlertURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("User click on the Click for JS Alert")
    public void user_click_on_the_Click_for_JS_Alert() {
        page.jsAlert.click();
        AlertHelper.getAlert();

    }

    @Then("User verify text in alert and click on Ok butten")
    public void user_verify_text_in_alert_and_click_on_Ok_butten() {
        AlertHelper.AcceptAlert();
        String expectdMsg = "You successfuly clicked an alert";
        String realMsg = page.tMessage.getText();
        System.out.println(expectdMsg);
        System.out.println(realMsg);
        Assert.assertEquals(expectdMsg, realMsg);


    }


    @Then("User Click for JS Confirm")
    public void user_Click_for_JS_Confirm() {
        page.confirmBtn.click();
        AlertHelper.getAlert();

    }

    @Then("User should verify text in alert and click on Ok butten")
    public void user_should_verify_text_in_alert_and_click_on_Ok_butten() {
      AlertHelper.AcceptAlert();
      String expectedMsg = "You clicked: Ok";
      String realMsg = page.tMessage.getText();
      Assert.assertEquals(expectedMsg, realMsg);
//        System.out.println(expectedMsg);
//        System.out.println(realMsg);
    }


    @Given("user click on the prom button and send message {string} and do verification")
    public void user_click_on_the_prom_button_and_send_message_and_do_verification(String message) {
        page.promBtn.click();
        AlertHelper.getAlert();
        AlertHelper.sendKeysAlert(message);
        String realMsg = page.tMessage.getText();
        String expctMsg = "You entered: "+ message;
        Assert.assertEquals(expctMsg, realMsg);
        Driver.closeDriver();
    }




    public void tearDown(){

    }
}
