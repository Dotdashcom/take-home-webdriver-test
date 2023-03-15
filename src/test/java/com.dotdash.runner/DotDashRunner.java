package com.dotdash.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features= {"C:\\Users\\Sugeesh\\eclipse-workspace\\DotDash1\\Features"},
	glue= {"com.dotdash.stepDefinitions"},
	stepNotifications=true,
	plugin= {"pretty","html:target/cucumber-reports.html"},
//	dryRun=true,
	tags="@Test",
	monochrome=true
	
				)



public class DotDashRunner {

}

