package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.JSErrorPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class JSErrorDef extends TestBase {

	@Given("User launches the JS error page")
	public void user_launches_the_JSerror() {
        TestBase tb= new TestBase();
        String addPath="javascript_error";
        tb.setupdownload(addPath);
	}    
    @When("checkfor JS error and verify the text")
    public void checkForJSError() {
    	JSErrorPOM jse= new JSErrorPOM();
    	jse.userCheckJSError();
    }
}
