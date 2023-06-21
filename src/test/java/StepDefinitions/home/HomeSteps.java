package StepDefinitions.home;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class HomeSteps {
    WebDriver driver;
    private final PageObject pageObject;

    public HomeSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @Given("the user is on example home page")
    public void the_user_is_on_example_home_page() {
        pageObject.homePage().navigateToHomePage();
    }
    @Then("the user should see the example home page")
    public void the_user_should_see_the_example_home_page() {
        pageObject.homePage().verifyHomePage();
    }
}
