package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *   Author : Zeynab Babaei
 */

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/uiFeature",
        glue = {"ui_automation/step_definition"},
        dryRun = false,
        tags = {"@check"},
        monochrome = true

)

public class UITestRunner {
}
