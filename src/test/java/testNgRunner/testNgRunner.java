package testNgRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(  //cucumber annotation
			features = "Feature",
			glue = "stepDefinition"
		)

public class testNgRunner extends AbstractTestNGCucumberTests{

}
