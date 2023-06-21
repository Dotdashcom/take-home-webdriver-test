package StepDefinitions.dynamicLoading;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public DynamicLoadingSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user click on dynamic loading page")
    public void the_user_click_on_dynamic_loading_page() {
      pageObject.dynamicLoadingPage().the_user_click_on_dynamic_loading_page();
    }
    @Then("the user should see the dynamic loading page")
    public void the_user_should_see_the_dynamic_loading_page() {
        pageObject.dynamicLoadingPage().the_user_should_see_the_dynamic_loading_page();
    }

    @When("the user clicks on the {string} link on the dynamic loading page")
    public void the_user_clicks_on_the_link_on_the_dynamic_loading_page(String exampleLink) {
        pageObject.dynamicLoadingPage().the_user_clicks_on_the_link_on_the_dynamic_loading_page(exampleLink);
    }
    @Then("the user should see the {string} page on the dynamic loading page")
    public void the_user_should_see_the_page_on_the_dynamic_loading_page(String dynamicContentPage) {
        pageObject.dynamicLoadingPage().the_user_should_see_the_page_on_the_dynamic_loading_page(dynamicContentPage);

    }
    @When("the user clicks on the {string} Button to view elements on the dynamic loading page")
    public void the_user_clicks_on_the_button_to_view_elements_on_the_dynamic_loading_page(String startButton) {
        pageObject.dynamicLoadingPage().the_user_clicks_on_the_button_to_view_elements_on_the_dynamic_loading_page(startButton);
    }
    @Then("the user should see the {string} text is displayed on the dynamic loading page")
    public void the_user_should_see_the_text_is_displayed_on_the_dynamic_loading_page(String dynamicText) {
        pageObject.dynamicLoadingPage().the_user_should_see_the_text_is_displayed_on_the_dynamic_loading_page(dynamicText);
    }
}
