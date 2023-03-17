package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.NewTabPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class NewTabStep extends BaseClass{

    @Given("User launches the newTab page")
    public void user_launches_the_newtab() {
        BaseClass tb= new BaseClass();
        String addPath="windows";
        tb.setupDownload(addPath);
    }
    @When("User clicks on clickhere link")
    public void clickHereLink() {
        NewTabPages newtab= new NewTabPages();
        newtab.clickLink();
    }

    @And("User moves to the new tab")
    public void newTab() {
        NewTabPages newtab= new NewTabPages();
        newtab.switchNewTab();
    }

    @Then("User asserts the text on the new window")
    public void assertNewWindowText() {
        NewTabPages newtab= new NewTabPages();
        String tabText=newtab.assertText();
        Assert.assertEquals(tabText, prop.getProperty("newTabText"));
    }
}
