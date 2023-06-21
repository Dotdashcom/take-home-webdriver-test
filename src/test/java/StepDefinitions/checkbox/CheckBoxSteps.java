package StepDefinitions.checkbox;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CheckBoxSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public CheckBoxSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user click on checkbox page")
    public void the_user_click_on_checkbox_page() {
        pageObject.checkBoxPage().the_user_click_on_checkbox_page();

    }
    @Then("the use should see the checkbox page")
    public void the_use_should_see_the_checkbox_page() {
        pageObject.checkBoxPage().the_use_should_see_the_checkbox_page();

    }
    @When("the user should check all the checkboxes on the checkbox page")
    public void the_user_should_check_all_the_checkboxes_on_the_checkbox_page() {
        pageObject.checkBoxPage().the_user_should_check_all_the_checkboxes_on_the_checkbox_page();

    }
    @Then("the user should see all the checkboxes are checked on the checkbox page")
    public void the_user_should_see_all_the_checkboxes_are_checked_on_the_checkbox_page() {
        pageObject.checkBoxPage().the_user_should_see_all_the_checkboxes_are_checked_on_the_checkbox_page();

    }
    @When("the user should uncheck all the checkboxes on the checkbox page")
    public void the_user_should_uncheck_all_the_checkboxes_on_the_checkbox_page() {
        pageObject.checkBoxPage().the_user_should_uncheck_all_the_checkboxes_on_the_checkbox_page();

    }
    @Then("the user should see all the checkboxes are unchecked on the checkbox page")
    public void the_user_should_see_all_the_checkboxes_are_unchecked_on_the_checkbox_page() {
        pageObject.checkBoxPage().the_user_should_see_all_the_checkboxes_are_unchecked_on_the_checkbox_page();

    }
}
