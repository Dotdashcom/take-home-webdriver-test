package dot.dash.step_definitions;

import dot.dash.pages.IfarmePage;
import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Iframe_steps {

    IfarmePage ifp = new IfarmePage();
    String msg = "";

    @When("user types {string} on text box")
    public void user_types_on_text_box(String str) {
        msg = str;
        try {
            ifp.closeBtn.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Driver.getDriver().switchTo().frame(ifp.framei);
        ifp.inputText.clear();
        ifp.inputText.sendKeys(msg);
    }

    @Then("verify the text is displayed as expected")
    public void verify_the_text_is_displayed_as_expected() {
        Assert.assertTrue(ifp.textsInsideP().stream().anyMatch(m -> m.equals(msg)));
    }
}
