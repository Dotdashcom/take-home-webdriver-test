package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class T16_StepDef {


    @Then("verify that the page contains error: {string}")
    public void verify_that_the_page_contains_error(String errorMsg) {

        List<LogEntry> jsErrors= Driver.getDriver().manage().logs().get(LogType.BROWSER).getAll();
        //This element has --> Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')
        System.out.println(jsErrors.get(jsErrors.size() - 1).getMessage());

        Assert.assertTrue(jsErrors.get(jsErrors.size()-1).getMessage().contains(errorMsg));


   }
}
