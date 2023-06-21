package StepDefinitions.dropDown;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DropDownSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public DropDownSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user click on dropdown page")
    public void the_user_click_on_dropdown_page() {
       pageObject.dropDownPage().the_user_click_on_dropdown_page();
    }
    @Then("the use should see the dropdown page")
    public void the_use_should_see_the_dropdown_page() {
        pageObject.dropDownPage().the_use_should_see_the_dropdown_page();

    }
    @When("the user select {string} dropdown on the dropdown page")
    public void the_user_select_dropdown_on_the_dropdown_page(String option) {
        pageObject.dropDownPage().the_user_select_dropdown_on_the_dropdown_page(option);
    }
    @Then("the user should see {string} dropdown is selected on the dropdown page")
    public void the_user_should_see_dropdown_is_selected_on_the_dropdown_page(String option) {
        pageObject.dropDownPage().the_user_should_see_dropdown_is_selected_on_the_dropdown_page(option);
    }

}
