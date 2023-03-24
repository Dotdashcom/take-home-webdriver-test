package dot.dash.step_definitions;

import dot.dash.pages.ContextPage;
import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class Context_steps {

    ContextPage cp = new ContextPage();

    @When("user performs Right-click on the box")
    public void user_performs_right_click_on_the_box() {
        Actions act = new Actions(Driver.getDriver());

        act.contextClick(cp.box).perform();

    }

    @Then("user mut see alert displayed on the page")
    public void user_mut_see_alert_displayed_on_the_page() {

        Alert alert = Driver.getDriver().switchTo().alert();
        String actualText = alert.getText();

        String expected = "You selected a context menu";

        alert.accept();

        Assert.assertEquals(actualText, expected);


    }
}
