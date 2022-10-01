package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumber-report.html", "rerun:target/rerun.txt",
                    "json:target/cucumber-report.json",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber"
            },
            features = "src/test/resources/features" ,
            glue = "StepDef",
            dryRun = false,
            tags = "@Test" )

    public class Runner { }
