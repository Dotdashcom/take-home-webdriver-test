package MarionelaTirsina.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-report.html",//path from html report
                "json:target/cucumber.json",//path json
                "rerun:target/rerun.txt"},//this will generate the failed test
        features = "src/test/Resources", //passing the path of feature files
        glue="com/cybertek/step_definitions",// passing the path for step definition
        dryRun=false,
        tags=" @wikiScenarioOutline")

public class Runner {
}
