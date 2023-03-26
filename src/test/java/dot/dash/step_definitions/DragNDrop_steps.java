package dot.dash.step_definitions;

import dot.dash.pages.DragND;
import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop_steps {
    DragND dNd = new DragND();
    String elABefore = "";
    String elBBefore = "";

    @When("drags element {string} to element {string}")
    public void drags_element_to_element(String a, String b) {

        Actions act = new Actions(Driver.getDriver());
        elABefore = dNd.element(a).getText();
        elBBefore = dNd.element(b).getText();

        WebElement A = dNd.element(a);
        WebElement B = dNd.element(b);


        act.clickAndHold(A)
                .moveToElement(B)
                .release()
                .perform();


    }

    @Then("text on element A and B must be switched")
    public void text_on_element_a_and_b_must_be_switched() {

        String elAAfter = dNd.element("a").getText();
        String elBAfter = dNd.element("b").getText();
        Assert.assertEquals(elBAfter, elABefore);
        Assert.assertEquals(elAAfter, elBBefore);


    }
}
