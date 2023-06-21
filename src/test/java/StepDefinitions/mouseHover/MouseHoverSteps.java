package StepDefinitions.mouseHover;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class MouseHoverSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public MouseHoverSteps() {
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on the mouse hover page")
    public void the_user_clicks_on_the_mouse_hover_page() {
        pageObject.mouseHoverPage().the_user_clicks_on_the_mouse_hover_page();
    }
    @Then("the user should see the mouse hover page")
    public void the_user_should_see_the_mouse_hover_page() {
       pageObject.mouseHoverPage().the_user_should_see_the_mouse_hover_page();
    }
    @When("the user hover mouse on the mouse hover page")
    public void the_user_hover_mouse_on_the_mouse_hover_page() {
       pageObject.mouseHoverPage().the_user_hover_mouse_on_the_mouse_hover_page();
    }

    @Then("the user should see the hover text {string} on the mouse hover page")
    public void theUserShouldSeeTheHoverTextOnTheMouseHoverPage(String mouseHoverText) {
        pageObject.mouseHoverPage().theUserShouldSeeTheHoverTextOnTheMouseHoverPage(mouseHoverText);
    }
}
