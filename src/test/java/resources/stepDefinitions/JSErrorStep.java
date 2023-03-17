package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.JSErrorPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class JSErrorStep extends BaseClass{

    @Given("User launches the JS error page")
    public void user_launches_the_JSerror() {
        BaseClass tb= new BaseClass();
        String addPath="javascript_error";
        tb.setupDownload(addPath);
    }
    @When("Check for JS error and verify the text")
    public void checkForJSError() {
        JSErrorPages jse= new JSErrorPages();
        jse.userCheckJSError();
    }
}
