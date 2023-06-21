package StepDefinitions.javaScriptError;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class JavaScriptErrorSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public JavaScriptErrorSteps() {
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on the JavaScript Error page")
    public void the_user_clicks_on_the_java_script_error_page() {
        pageObject.javaScriptErrorPage().the_user_clicks_on_the_java_script_error_page();
    }
    @Then("the user should see the JavaScript Error page")
    public void the_user_should_see_the_java_script_error_page() {
        pageObject.javaScriptErrorPage().the_user_should_see_the_java_script_error_page();

    }
    @Then("the user verifies that there is a JavaScript Error on the JavaScript Error page")
    public void the_user_verifies_that_there_is_a_java_script_error_on_the_java_script_error_page() {
        pageObject.javaScriptErrorPage().the_user_verifies_that_there_is_a_java_script_error_on_the_java_script_error_page();
    }
    @Then("the user should see the Javascript Error {string} on the JavaScript Error page")
    public void the_user_should_see_the_javascript_error_on_the_java_script_error_page(String JSError) {
        pageObject.javaScriptErrorPage().the_user_should_see_the_javascript_error_on_the_java_script_error_page(JSError);
    }

}
