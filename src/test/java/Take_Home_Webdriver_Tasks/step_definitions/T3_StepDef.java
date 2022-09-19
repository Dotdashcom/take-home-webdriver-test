package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.CheckboxPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class T3_StepDef  {
    CheckboxPage page = new CheckboxPage();

    @Then("verify checkbox one is NOT selected by default")
    public void verify_checkbox_one_is_not_selected_by_default() {
        Assert.assertFalse("C1 is selected",page.checkBox1.isSelected());

    }
    @Then("verify checkbox two is SELECTED by default")
    public void verify_checkbox_two_is_selected_by_default() {
        Assert.assertTrue("C2 is not selected",page.checkBox2.isSelected());
    }


}
