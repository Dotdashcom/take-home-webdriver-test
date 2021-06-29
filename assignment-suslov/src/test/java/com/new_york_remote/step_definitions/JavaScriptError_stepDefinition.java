package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.JavaScriptErrorPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class JavaScriptError_stepDefinition {
    JavaScriptErrorPage javaScriptErrorPage=new JavaScriptErrorPage();
    @When("user is on the JavaScript Error page")
    public void user_is_on_the_java_script_error_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/javascript_error");
    }




    @Then("asserts that the page contains error")
    public void asserts_that_the_page_contains_error() {
        Assert.assertTrue(javaScriptErrorPage.text.getText().contains("error"));
    }


}
