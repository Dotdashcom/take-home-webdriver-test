package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features"
        , glue = "steps"
        , dryRun = false
        , monochrome = true
        //, tags = "@tag"
        , plugin = {"pretty",
        "html:target/cucumber-html-report",
        "json:target/cucumber.xml",
        "json:target/cucumber.json"
        , "rerun:target/rerun.txt"}


)

public class TestRunner {

}
