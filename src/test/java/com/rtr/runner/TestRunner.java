package com.rtr.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// We can specify which feature/features to run
		features = "src/test/resources/features/",
		// we can specify where the code for the above feature
		glue = "com.rtr.steps",
		// if true, it does not run the java classes
		// if they are glued to some java code
		dryRun = false,
		// tags can do the same thing groups on TestNG
		tags= "@Test",
		monochrome = true
        
		)

public class TestRunner {

}
