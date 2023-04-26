package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.JSAlertsPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class JSAlertsStep extends BaseClass{

    @Given("User launches the JS alerts page")
    public void user_launches_the_JSalerts() {
        BaseClass tb= new BaseClass();
        //  tb.setup();
        String addPath="javascript_alerts";
        tb.setupDownload(addPath);
    }
    @When("User clicks on JS Alert")
    public void switchJSAlerts() {
        JSAlertsPages jsa= new JSAlertsPages();
        jsa.switchToJSAlert();
    }

    @Then("User verifies JS Alert message")
    public void verifyJSAlertText() {
        JSAlertsPages jsa= new JSAlertsPages();
        String JSAlert=jsa.JSAlertText();
        Assert.assertEquals(JSAlert, prop.getProperty("JSAlertText"));
    }

    @When("User clicks on JS Confirm")
    public void switchJSConfirm() {
        JSAlertsPages jsa= new JSAlertsPages();
        jsa.switchToJSConfirm();

    }
    @Then("User verifies JS Confirm message")
    public void verifyJSConfirmText() {
        JSAlertsPages jsa= new JSAlertsPages();
        String JSConfirm=jsa.JSAlertText();
        Assert.assertEquals(JSConfirm, prop.getProperty("JSConfirmText"));
    }

    @When("User clicks on JS Prompt")
    public void switchJSPrompt() {
        JSAlertsPages jsa= new JSAlertsPages();
        jsa.switchToJSPrompt();
    }
    @Then("User verifies JS Prompt message")
    public void verifyJSPromptText() {
        JSAlertsPages jsa= new JSAlertsPages();
        String jsText=jsa.JSPromptText();
        Assert.assertTrue(jsText.contains(prop.getProperty("JSPromptTextVerify")));
    }
}
