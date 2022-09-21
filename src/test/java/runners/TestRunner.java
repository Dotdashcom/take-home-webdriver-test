package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * this method runs specific tag/test from feature files and creates visual
 * report
 * 
 * @author farkhadyakhshibaev
 *
 */

@RunWith(Cucumber.class)

@CucumberOptions(

		features = "src/test/resources/features/",

		glue = "steps",

		dryRun = false,

		tags = "@Test",

		monochrome = true
		//

)

public class TestRunner {

}
