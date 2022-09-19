package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.ContextMenuPage;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class T4_StepDef {
    ContextMenuPage page = new ContextMenuPage();

    @When("user right click on the box")
    public void user_right_click_on_the_box() {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(page.contextMenuBox).perform();

    }
    @Then("verify JavaScript alert text")
    public void verify_java_script_alert_text() {

        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals("You selected a context menu",alert.getText());
    }
}
