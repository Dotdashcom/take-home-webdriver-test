package resources.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/java/resources/features"},
        glue= {"src/test/java/resources/stepDefinitions"},
        stepNotifications=true,
        plugin= {"pretty","html:target/cucumber-reports.html"},
    	dryRun=false,
        tags="@UAT",
        monochrome=true
)

public class CucumberRunner {

}