package com.dotdash.stepDefinitions;

import org.junit.Assert;

import com.dotdash.pageObjects.LoginPOM;
import com.dotdash.testUtils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSuccessDef extends TestBase {



	@Given("User launches the loginpage")
	public void user_launches_the_website() {
         TestBase tb= new TestBase();
       //  tb.setup();
         String addPath="login";
         tb.setupdownload(addPath);
	}
	
    @When("The user enters {string} and {string}")
    public void enterUserNameAndPassword(String username, String password) {
    	LoginPOM lm= new LoginPOM();
    	lm.login(username,password);
    	System.out.println("**************88");
    	System.out.println(driver.getTitle());
}
    @And("User clicks the login button")
    public void userClickLogin() {
    	LoginPOM lm= new LoginPOM();
    	lm.clickLoginButton();
    }
    
    @Then("User verifys the login success text")
    public void checkloginSuccessText() {
    	LoginPOM lm= new LoginPOM();
    	String loginSText=lm.checkLoginText();   	
    	System.out.println(loginSText);
    	System.out.println(prop.getProperty("LoginSuccessText"));
    	Boolean flag=loginSText.contains(prop.getProperty("LoginSuccessText"));

    	Assert.assertEquals(flag,true);  
    }
    
    @Then("User verifys the login failure text")
    public void checkloginFailureText() {
    	LoginPOM lm= new LoginPOM();
    	String loginFText=lm.checkLoginText();  
    	System.out.println(loginFText);
    	Boolean flag= loginFText.contains(prop.getProperty("LoginFailureText"));
    	System.out.println(flag);
    	Assert.assertEquals(flag, true);
    	
    }
}
