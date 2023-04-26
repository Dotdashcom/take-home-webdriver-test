package resources.stepDefinitions;

import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import resources.pages.CheckBoxPages;
import resources.utilities.BaseClass;

public class CheckBoxStep extends BaseClass {

    Boolean status;
    WebElement checkbox;

    @Given("User launches the checkBoxPage")
    public void user_launches_the_checkBoxPage() {
        BaseClass tb = new BaseClass();
        //  tb.setup();
        String addPath = "checkboxes";
        tb.setupDownload(addPath);
    }

    @When("User clicks the checkBox1")
    public void checksCheckbox() {
        CheckBoxPages cb = new CheckBoxPages();
        checkbox = cb.clicksCheckBox1();
    }

    @And("User verifies if checkBox1 is checked")
    public void verifyCheckboxStatus() {
        CheckBoxPages cb = new CheckBoxPages();
        status = cb.verifyCheckBoxIsChecked(checkbox);
        System.out.println(status);
        Assert.assertTrue(status);
    }

    @And("User verifies if checkBox1 is unchecked")
    public void CheckBoxUnchecked() {
        CheckBoxPages cb = new CheckBoxPages();
        status = cb.verifyCheckBoxIsChecked(checkbox);
        System.out.println(status);
        Assert.assertFalse(status);
    }
}
