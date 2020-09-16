package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/automation/steps",
//        tags = "@18_notifications",
//        dryRun = true,
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        }
)
public class CucesRunner {

}