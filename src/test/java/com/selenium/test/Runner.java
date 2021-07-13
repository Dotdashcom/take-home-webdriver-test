package com.selenium.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.selenium.test.util.Hooks;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:target/report/seleniumtest.json"}, 
		features = "src/test/resources/",
        glue = {"com.selenium.test.stepdefinitions"},
        tags = {"@All"},
        dryRun = false,
        monochrome = true)
public class Runner {
		
	@BeforeClass
	public static void OpenBrowser(){
		
		Hooks.openDriver();
	}
		
	

	@AfterClass
	public static void CloseBrowser(){
		
		Hooks.closeDriver();
	}
}
