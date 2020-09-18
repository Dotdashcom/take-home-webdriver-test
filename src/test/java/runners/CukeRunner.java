package runners;






import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions (

        plugin = {

                "html:target/built-in-html-report",
                "json:target/Cucumber.json "

        },

        tags = "@Test", //
        features = "src/test/resources/features",
        glue = "stepDefs"
//		,strict = true
	//,dryRun = true
        ,monochrome =true
//		,stepNotifications = true
//		,snippets = SnippetType.CAMELCASE
)
public class CukeRunner {

}