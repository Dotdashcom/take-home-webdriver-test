package StepDefinitions.floatingMenu;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FloatingMenuSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public FloatingMenuSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on floating menu page")
    public void the_user_clicks_on_floating_menu_page() {
        pageObject.floatingMenuPage().the_user_clicks_on_floating_menu_page();
    }
    @Then("the user should see the floating menu page")
    public void the_user_should_see_the_floating_menu_page() {
        pageObject.floatingMenuPage().the_user_should_see_the_floating_menu_page();
    }
    @When("the user scrolls on the floating menu page")
    public void the_user_scrolls_on_the_floating_menu_page() {
        pageObject.floatingMenuPage().the_user_scrolls_on_the_floating_menu_page();
    }
    @Then("the user should see the floating menu is still displayed on the floating menu page")
    public void the_user_should_see_the_floating_menu_is_still_displayed_on_the_floating_menu_page() {
        pageObject.floatingMenuPage().the_user_should_see_the_floating_menu_is_still_displayed_on_the_floating_menu_page();
    }
}
