package com.trudova.getInProj.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "@target/rerun.txt",
        glue = "com/trudova/getInProj/step_definitions"
)
public class FaildTestRunner {

}
