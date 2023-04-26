package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.FramesPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class FramesStep extends BaseClass{

    @Given("User launches the iFrame page")
    public void userLaunchesTheiFrame() {
        BaseClass tb= new BaseClass();
        String addPath="iframe";
        tb.setupDownload(addPath);
    }

    @When("User switches to iframe")
    public void switchToiframe() {
        FramesPages ifr= new FramesPages();
        ifr.swtIFrame();
    }

    @And("User enters text in iframe")
    public void enterText() {
        FramesPages ifr= new FramesPages();
        ifr.enterTextIframe();
    }

    @Then("User verifies the text in the iframe")
    public void verifyText() {
        FramesPages ifr= new FramesPages();
        String iframeText=ifr.verifyIframeText();
        Assert.assertEquals(iframeText,prop.getProperty("TextOnIframe") );
    }
}
