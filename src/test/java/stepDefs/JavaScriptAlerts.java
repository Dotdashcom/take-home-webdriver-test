package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utils.Driver;

public class JavaScriptAlerts {
    @Given("I am on the JavaScript Alerts  page")
    public void i_am_on_the_JavaScript_Alerts_page() {
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

    }

    @When("I click on JS Alert Button")
    public void i_click_on_JS_Alert_Button() {
Driver.getDriver().findElement(By.xpath("//button[text()='Click for JS Alert' ]")).click();
    }

    @Then("I verify alert message")
    public void i_verify_alert_message() {
Alert alert = Driver.getDriver().switchTo().alert();
String textOnAlert=alert.getText();
System.out.println("The alert message is " + textOnAlert);
alert.accept();
    }

    @When("I click on JS confirm Button and click ok on alert")
    public void i_click_on_JS_confirm_Button_and_click_ok_on_alert() {
        Driver.getDriver().findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    }

    @Then("I verify the alert message")
    public void i_verify_the_alert_message() {
        Alert alert = Driver.getDriver().switchTo().alert();
        String textOnAlert=alert.getText();
        String expected = "I am a JS Confirm";
        Assert.assertTrue(textOnAlert.contains(expected));
        System.out.println("The alert message of JS confirm Button is " + textOnAlert);
        alert.accept();
    }

    @When("I click on JS Prompt Button and type a message on prompt")
    public void i_click_on_JS_Prompt_Button_and_type_a_message_on_prompt() {
        Driver.getDriver().findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

    }

    @Then("I verify that the alert message contains the typed message.")
    public void i_verify_that_the_alert_message_contains_the_typed_message() throws InterruptedException {
        Alert alert = Driver.getDriver().switchTo().alert();
        //String expected = "Hello World!";
        Thread.sleep(2000);
        alert.sendKeys("Hello!");
        alert.accept();

    }

}
