package StepDefinitions.dynamicControls;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DynamicControlsSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public DynamicControlsSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user click on dynamic control page")
    public void the_user_click_on_dynamic_control_page() {
        pageObject.dynamicControlsPage().the_user_click_on_dynamic_control_page();

    }
    @Then("the use should see the dynamic control page")
    public void the_use_should_see_the_dynamic_control_page() {
        pageObject.dynamicControlsPage().the_use_should_see_the_dynamic_control_page();
    }
    @When("the user clicks on the {string} Button to remove the checkbox on the dynamic control page")
    public void the_user_clicks_on_the_to_remove_the_checkbox_on_the_dynamic_control_page(String removeButton) {
        pageObject.dynamicControlsPage().the_user_clicks_on_the_to_remove_the_checkbox_on_the_dynamic_control_page(removeButton);

    }
    @Then("the user should see the checkbox is removed on the dynamic control page")
    public void the_user_should_see_the_checkbox_is_removed_on_the_dynamic_control_page() {
        pageObject.dynamicControlsPage().the_user_should_see_the_checkbox_is_removed_on_the_dynamic_control_page();
    }
    @When("the user clicks on the {string} Button to add the checkbox on the dynamic control page")
    public void the_user_clicks_on_the_to_add_the_checkbox_on_the_dynamic_control_page(String addButton) {
        pageObject.dynamicControlsPage().the_user_clicks_on_the_to_add_the_checkbox_on_the_dynamic_control_page(addButton);

    }
    @Then("the user should see the checkbox is added on the dynamic control page")
    public void the_user_should_see_the_checkbox_is_added_on_the_dynamic_control_page() {
        pageObject.dynamicControlsPage().the_user_should_see_the_checkbox_is_added_on_the_dynamic_control_page();
    }
    @When("the user clicks on the {string} button to enable the text box on the dynamic control page")
    public void the_user_clicks_on_the_button_to_enable_the_text_box_on_the_dynamic_control_page(String enableButton) {
        pageObject.dynamicControlsPage().the_user_clicks_on_the_button_to_enable_the_text_box_on_the_dynamic_control_page(enableButton);

    }
    @Then("the user should see the text box is enabled on the dynamic control page")
    public void the_user_should_see_the_text_box_is_enabled_on_the_dynamic_control_page() {
        pageObject.dynamicControlsPage().the_user_should_see_the_text_box_is_enabled_on_the_dynamic_control_page();

    }
    @When("the user clicks on the {string} button to disable the text box on the dynamic control page")
    public void the_user_clicks_on_the_button_to_disable_the_text_box_on_the_dynamic_control_page(String disableButton) {
        pageObject.dynamicControlsPage().the_user_clicks_on_the_button_to_disable_the_text_box_on_the_dynamic_control_page(disableButton);
    }
    @Then("the user should see the text box is disabled on the dynamic control page")
    public void the_user_should_see_the_text_box_is_disabled_on_the_dynamic_control_page() {
        pageObject.dynamicControlsPage().the_user_should_see_the_text_box_is_disabled_on_the_dynamic_control_page();
    }
}
