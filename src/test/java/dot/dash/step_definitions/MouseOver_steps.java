package dot.dash.step_definitions;

import dot.dash.pages.MouseOver;
import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class MouseOver_steps {
    MouseOver ms = new MouseOver();

    @Then("verify additional info displayed when mouse hovered over images")
    public void verify_additional_info_displayed_when_mouse_hovered_over_images() {
        Actions act = new Actions(Driver.getDriver());

        for (int i = 1; i <= ms.numberOfImages(); i++) {
            act.moveToElement(ms.images(i)).perform();
            for (int j = 0; j < 2; j++) {
                Assert.assertTrue(ms.infos(i).get(j).isDisplayed());
            }
        }

    }
}
