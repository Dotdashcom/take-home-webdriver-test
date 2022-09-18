package Take_Home_Webdriver_Tasks.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber-report.json",
        },

        features = "src/test/resources/features",
        glue = "Take_Home_Webdriver_Tasks/step_definitions",
        dryRun = false,
        tags = ""
)

public class runner {

}
