package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.BasePage;
import Take_Home_Webdriver_Tasks.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class T1_T2_StepDef {

    LoginPage loginPage=new LoginPage();


    @Given("user is on the {string} page")
    public void user_is_on_the_page(String page) {

        BasePage.navigateToPage(page);
    }
    @When("user enters {string} credentials")
    public void user_enters_credentials(String userType) {
        loginPage.loginDynamically(userType);

    }

    @Then("user should see {string} msg")
    public void user_should_see_msg(String lgnMsg) {

        String actualMsg = loginPage.loginPageMsg.getText();
        Assert.assertTrue("No Match!",actualMsg.contains(lgnMsg));


    }

}
