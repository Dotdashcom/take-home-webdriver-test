package com.theInternet.Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/theInternet/StepDefinitions",
        dryRun = false,
        tags = "@Test14"
)
public class Runner {

}
