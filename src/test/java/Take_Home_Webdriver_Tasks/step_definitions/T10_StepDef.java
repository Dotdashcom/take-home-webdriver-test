package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.FilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T10_StepDef {
    FilePage filePage = new FilePage();

    @When("user clicks on file")
    public void user_clicks_on_file() {

        List<WebElement> allFiles = filePage.files;
        for(WebElement each : allFiles){
            each.click();
        }
    }
    @Then("verify that the file is downloaded")
    public void verify_that_the_file_is_downloaded() {

        // Selenium can not test desktop application and does not support file upload facility
    }
}
