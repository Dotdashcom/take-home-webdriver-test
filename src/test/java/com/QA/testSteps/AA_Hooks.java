package com.QA.testSteps;

import org.testng.asserts.SoftAssert;

import com.QA.BaseUtils.BaseClass;
import com.QA.BaseUtils.CommonMethods;
import com.QA.BaseUtils.ConfigsReader;
import com.QA.BaseUtils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AA_Hooks extends CommonMethods {
	
	public static Scenario scenario;	
	
	public static SoftAssert softAssert;	
	
	@Before
	public void start(Scenario scenario) {	
		AA_Hooks.scenario=scenario;
		
		BaseClass.setUp();	
		
		softAssert = new SoftAssert();	
		
	}
	

	@After
	public void end() {		
			
		byte[] pic;
		if (scenario.isFailed()) {
			pic = CommonMethods.takeScreenshot("failed/" + scenario.getName());
		} else {
			pic = CommonMethods.takeScreenshot("passed/" + scenario.getName());			
		}			
		scenario.attach(pic, "image/png", scenario.getName());
		

		if (driver != null && ConfigsReader.readAndGetProperty(Constants.CONFIGURATION_FILEPATH, "closeBrowserWindowAfter").equalsIgnoreCase("yes")) {
			BaseClass.tearDown();
		}		
		
		try {
			softAssert.assertAll();			
		} catch (Exception e) {	}

		
	}

}