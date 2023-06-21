package runnerPackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import com.example.manager.WebDriverManager;
import com.example.utils.ReadProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
                  glue = {"StepDefinitions"},
                  monochrome = true,
                  plugin = {
                    "pretty",
                     "json:target/cucumber-inbuilt-report/AllTestReport.json",
                     "html:target/cucumber-inbuilt-report/AllTestReport.html",
                     "junit:target/cucumber-inbuilt-report/AllTestRepor.xml"
                  }
)

public class RunnerTest {
    static WebDriverManager webDriverManager;
    static ReadProperties readProperties;

    @BeforeClass
    public static void setup(){
        webDriverManager = new WebDriverManager();
        readProperties = new ReadProperties();
    }

    @AfterClass
    public static void tearDown(){
        webDriverManager.closeDriver();
    }

}
