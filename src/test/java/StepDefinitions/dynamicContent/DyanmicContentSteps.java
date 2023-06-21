package StepDefinitions.dynamicContent;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DyanmicContentSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public DyanmicContentSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user click on dynamic content page")
    public void the_user_click_on_dynamic_content_page() {
        pageObject.dynamicContentPage().the_user_click_on_dynamic_content_page();
    }
    @Then("the use should see the dynamic content page")
    public void the_use_should_see_the_dynamic_content_page() {
        pageObject.dynamicContentPage().the_use_should_see_the_dynamic_content_page();

    }
    @When("the user clicks on the {string} link on the dynamic content page")
    public void the_user_clicks_on_the_link_on_the_dynamic_content_page(String clickHere) {
        pageObject.dynamicContentPage().the_user_clicks_on_the_link_on_the_dynamic_content_page(clickHere);
    }
    @Then("the user should see the page is refreshed on the dynamic content page")
    public void the_user_should_see_the_page_is_refreshed_on_the_dynamic_content_page() {
        pageObject.dynamicContentPage().the_user_should_see_the_page_is_refreshed_on_the_dynamic_content_page();
    }
}
