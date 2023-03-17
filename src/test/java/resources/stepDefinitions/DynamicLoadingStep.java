package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.DynamicLoadingPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicLoadingStep extends BaseClass{

    @Given("User launches the dynamic loading page")
    public void userLaunchesTheDynamicLoading() {
        BaseClass tb= new BaseClass();
        String addPath="dynamic_loading/2";
        tb.setupDownload(addPath);
    }
    @When("User clicks on start button")
    public void clickStart() {
        DynamicLoadingPages dl= new DynamicLoadingPages();
        dl.userClickStart();
    }
    @And("User waits for helloworld text to be displayed")
    public void verifyHelloWord() {
        DynamicLoadingPages dl= new DynamicLoadingPages();
        dl.userVerifyHelloWord();
    }

    @Then("User verifies the helloworld text")
    public void verifyHelloWordText() {
        DynamicLoadingPages dl= new DynamicLoadingPages();
        dl.userVerifyHelloWordText();
    }
}
