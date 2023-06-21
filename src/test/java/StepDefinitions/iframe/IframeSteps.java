package StepDefinitions.iframe;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class IframeSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public IframeSteps() {
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on the frame page")
    public void the_user_clicks_on_the_frame_page() {
       pageObject.iframePage().the_user_clicks_on_the_frame_page();
    }
    @Then("the user should see the frame page")
    public void the_user_should_see_the_frame_page() {
        pageObject.iframePage().the_user_should_see_the_frame_page();
    }
    @When("the user clicks on the Iframe page")
    public void the_user_clicks_on_the_iframe_page() {
        pageObject.iframePage().the_user_clicks_on_the_iframe_page();
    }
    @Then("the user should see the iframe page")
    public void the_user_should_see_the_iframe_page() {
        pageObject.iframePage().the_user_should_see_the_iframe_page();
    }
    @When("the user switches to {string} on the Iframe page")
    public void the_user_switches_to_on_the_iframe_page(String iframeName) {
        pageObject.iframePage().the_user_switches_to_on_the_iframe_page(iframeName);

    }
    @When("the user type {string} on the current iframe textbox on the Iframe page")
    public void the_user_type_on_the_textbox_on_the_iframe_page(String testMessage) {
        pageObject.iframePage().the_user_type_on_the_textbox_on_the_iframe_page(testMessage);
    }
    @Then("the user should not see the text {string} on the default iframe on the Iframe page")
    public void the_user_should_not_see_the_text_on_the_iframe_on_the_iframe_page(String string) {
        pageObject.iframePage().the_user_should_not_see_the_text_on_the_iframe_on_the_iframe_page();
    }
    @Then("the user should see the text {string} on the iframe {string} on the Iframe page")
    public void the_user_should_see_the_text_on_the_iframe_on_the_iframe_page(String testText, String iframeName) {
        pageObject.iframePage().the_user_should_see_the_text_on_the_iframe_on_the_iframe_page(testText,iframeName);
    }
}
