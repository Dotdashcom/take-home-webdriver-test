package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(features = "@target/rerun.txt"
            , glue = "steps"
            , dryRun = false
            , monochrome = true
            , plugin = {"pretty"}


    )

    public class ReRunner {

    }

