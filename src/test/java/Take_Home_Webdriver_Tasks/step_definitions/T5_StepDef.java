package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.DragDropPage;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class T5_StepDef  {

    DragDropPage page = new DragDropPage();


    @When("user drags element A and drop into element B")
    public void user_drags_element_a_and_drop_into_element_b() {

        Actions actions = new Actions(Driver.getDriver());
       actions.clickAndHold(page.elementA).moveToElement(page.elementB).release().build().perform();
    }
    @Then("verify the text on element A and B are switched.")
    public void verify_the_text_on_element_a_and_b_are_switched() {

        Assert.assertEquals("B", page.elementB.getText());
    }
}
