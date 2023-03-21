package dot.dash.step_definitions;

import dot.dash.pages.CheckBox;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Checkbox_steps {

    CheckBox cb = new CheckBox();

    @Then("verify user is able to check and uncheck checkboxes")
    public void verify_user_is_able_to_check_and_uncheck_checkboxes() {

        for (int i = 1; i <= cb.numberOfCheckboxes(); i++) {
            for (int j = 0; j < 2; j++) {
                WebElement box = cb.checkB(i);
                boolean checked = box.isSelected();
                box.click();

                Assert.assertFalse(checked && cb.checkB(i).isSelected());
            }

        }

    }
}
