package resources.stepDefinitions;

import org.testng.Assert;
import resources.utilities.BaseClass;
import resources.pages.DynamicContentPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicContentStep extends BaseClass {

    String pageSource1,pageSource2;

    @Given("User launches the dynamic content page")
    public void userLaunchesTheDynamicContent() {
        BaseClass tb= new BaseClass();
        String addPath="dynamic_content";
        tb.setupDownload(addPath);
    }
    @When("user checks the page content")
    public void checkPageContent() {
        DynamicContentPages dc = new DynamicContentPages();
        pageSource1=dc.userCheckPageContent();

    }

    @And("user refreshes the page")
    public void refreshesPage() {
        DynamicContentPages dc = new DynamicContentPages();
        dc.userRefreshesPage();

    }

    @Then("user checks the page content after page refresh")
    public void checkPageContentAfterRefresh() {
        DynamicContentPages dc = new DynamicContentPages();
        pageSource2=dc.userCheckPageContentAfterRefresh();
    }

    @And("user verifies that page content has changed after refresh")
    public void checkPageContentChange() {
        Assert.assertNotEquals(pageSource2, pageSource1);
    }

}
