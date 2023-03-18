package dot.dash.step_definitions;

import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_steps {
    Select sel;

    @When("user selects {string} from dropdown")
    public void user_selects_from_dropdown(String option) {
        sel = new Select(Driver.getDriver().findElement(By.id("dropdown")));
        sel.selectByVisibleText(option);
    }
    @Then("verify {string} has been selected")
    public void verify_has_been_selected(String option) {
        String actualOption = sel.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,option);
    }
}
