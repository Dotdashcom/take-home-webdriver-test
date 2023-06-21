package StepDefinitions.openInNewTab;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class OpenInNewTabSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public OpenInNewTabSteps() {
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on the Open New Tab page")
    public void the_user_clicks_on_the_open_new_tab_page() {
       pageObject.openInNewTabPage().the_user_clicks_on_the_open_new_tab_page();
    }
    @Then("the user should see the Open New Tab page")
    public void the_user_should_see_the_open_new_tab_page() {
        pageObject.openInNewTabPage().the_user_should_see_the_open_new_tab_page();
    }
    @When("the user clicks on the {string} link on the Open New Tab page")
    public void the_user_clicks_on_the_link_on_the_open_new_tab_page(String clickHere) {
        pageObject.openInNewTabPage().the_user_clicks_on_the_link_on_the_open_new_tab_page(clickHere);
    }
    @Then("the user should see the new tab is opened with text {string}")
    public void the_user_should_see_the_new_tab_is_opened_with_text(String text) {
        pageObject.openInNewTabPage().the_user_should_see_the_new_tab_is_opened_with_text(text);
    }
}
