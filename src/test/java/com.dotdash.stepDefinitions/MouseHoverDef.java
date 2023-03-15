package com.dotdash.stepDefinitions;

import com.dotdash.pageObjects.MouseHoverPOM;
import com.dotdash.testUtils.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class MouseHoverDef extends TestBase {

	@Given("User launches the mousehover page")
	public void user_launches_the_mousehover() {
        TestBase tb= new TestBase();
        String addPath="hovers";
        tb.setupdownload(addPath);
	}    
    @When("User switch to First image")
    public void movetoFirstImage() {
    	MouseHoverPOM mh= new MouseHoverPOM();
    	mh.hoverOnFirstImage();
    	
    }
   
    @And("User verify the first text")
    public void userVerifyFirstText() {
    	MouseHoverPOM mh= new MouseHoverPOM();
    	String text=mh.checkfirstText();
    	Assert.assertEquals(text, prop.getProperty("FirstImgText"));
    	System.out.println(text);   	
    }
    @When("User switch to Second image")
    public void movetoSecondImage() {
    	MouseHoverPOM mh= new MouseHoverPOM();
    	mh.hoverOnSecondImage();
    	
    }
   
    @And("User verify the second text")
    public void userVerifySecondText() {
    	MouseHoverPOM mh= new MouseHoverPOM();
    	String text=mh.checkSecondText();
    	Assert.assertEquals(text, prop.getProperty("SecImgText"));
    	System.out.println(text);
    }
    
    @When("User switch to Third image")
    public void movetoThirdImage() {
    	MouseHoverPOM mh= new MouseHoverPOM();
    	mh.hoverOnThirdImage();
    	
    }
   
    @And("User reads the third text")
    public void userVerifyThirdText() {
    	MouseHoverPOM mh= new MouseHoverPOM();
    	String text=mh.checkThirdText();
    	Assert.assertEquals(text, prop.getProperty("ThirdIngText"));
    	System.out.println(text);
    } 
}
