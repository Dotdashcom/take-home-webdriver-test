package com.company.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features" ,
        glue = "com/company/step_definitions",
        dryRun = false,
        tags = "@Login_positive and @Login_negative"
)
public class CukesRunner {
}
