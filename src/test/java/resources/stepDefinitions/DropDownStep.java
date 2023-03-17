package resources.stepDefinitions;

import org.testng.Assert;
import resources.pages.DropDownPages;
import resources.utilities.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DropDownStep extends BaseClass{

    @Given("User launches the dropdown page")
    public void userLaunchesTheDropdown() {
        BaseClass tb= new BaseClass();
        String addPath="dropdown";
        tb.setupDownload(addPath);
    }
    @When("User selects option1")
    public void selectFirstOption() {
        DropDownPages dd=new DropDownPages();
        dd.selectOption1();
    }

    @And("User selects option2")
    public void selectSecOption() {
        DropDownPages dd=new DropDownPages();
        dd.selectOption2();
    }

    @Then("User verifies option1 is selected")
    public void option1Selected() {
        DropDownPages dd=new DropDownPages();
        boolean status=dd.isOption1Selected();
        Assert.assertEquals(status, true);
    }

    @Then("User verifies option2 is selected")
    public void option2Selected() {
        DropDownPages dd=new DropDownPages();
        boolean status=dd.isOption2Selected();
        Assert.assertEquals(status, true);
    }

    @Then("User verifies option1 is not selected")
    public void option1IsNotSelected() {
        DropDownPages dd=new DropDownPages();
        boolean status=dd.isOption1Selected();
        Assert.assertFalse(status);
    }

}
