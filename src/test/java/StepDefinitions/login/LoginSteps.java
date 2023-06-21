package StepDefinitions.login;

import com.example.navigation.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    WebDriver driver;
    private final PageObject pageObject;

    public LoginSteps(){
        driver = WebDriverManager.getDriver();
        this.pageObject = new PageObject(driver);
    }

    @When("the user clicks on login button on the homepage")
    public void the_user_clicks_on_login_button_on_the_homepage() {
        pageObject.loginPage().the_user_clicks_on_login_button_on_the_homepage();

    }
    @When("the user enters username as {string} on the login page")
    public void the_user_enters_username_as_on_the_login_page(String userName) {
        pageObject.loginPage().the_user_enters_username_as_on_the_login_page(userName);

    }
    @When("the user enters password as {string} on the login page")
    public void the_user_enters_password_as_on_the_login_page(String password) {
        pageObject.loginPage().the_user_enters_password_as_on_the_login_page(password);

    }
    @When("the user enters on the login button on the login page")
    public void the_user_enters_on_the_login_button_on_the_login_page() {
        pageObject.loginPage().the_user_enters_on_the_login_button_on_the_login_page();

    }
    @Then("the user should see the secure page")
    public void the_user_should_see_the_secure_page() {
        pageObject.loginPage().the_user_should_see_the_secure_page();

    }

    @Then("the user should see invalid username error on the login page")
    public void the_user_should_see_invalid_username_error_on_the_login_page() {
        pageObject.loginPage().the_user_should_see_invalid_username_error_on_the_login_page();
    }

    @Then("the user should see invalid password error on the login page")
    public void the_user_should_see_invalid_password_error_on_the_login_page() {
        pageObject.loginPage().the_user_should_see_invalid_password_error_on_the_login_page();
    }

}
