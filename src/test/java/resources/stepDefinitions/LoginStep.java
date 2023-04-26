package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.LoginPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep extends BaseClass{

    @Given("User launches the loginpage")
    public void userLaunchesTheWebsite() {
        BaseClass tb= new BaseClass();
        String addPath="login";
        tb.setupDownload(addPath);
    }

    @When("User enters {string} and {string}")
    public void enterUserNameAndPassword(String username, String password) {
        LoginPages lm= new LoginPages();
        lm.login(username,password);
        System.out.println("**************88");
        System.out.println(driver.getTitle());
    }

    @And("User clicks the login button")
    public void userClickLogin() {
        LoginPages lm= new LoginPages();
        lm.clickLoginButton();
    }

    @Then("User verifies the login success text")
    public void checkLoginSuccessText() {
        LoginPages lm= new LoginPages();
        String loginSText=lm.checkLoginText();
        System.out.println(loginSText);
        System.out.println(prop.getProperty("LoginSuccessText"));
        Boolean flag=loginSText.contains(prop.getProperty("LoginSuccessText"));

        Assert.assertEquals(flag,true);
    }

    @Then("User verifies the login failure text")
    public void checkLoginFailureText() {
        LoginPages lm= new LoginPages();
        String loginFText=lm.checkLoginText();
        System.out.println(loginFText);
        Boolean flag= loginFText.contains(prop.getProperty("LoginFailureText"));
        System.out.println(flag);

        Assert.assertEquals(flag, true);
    }
}
