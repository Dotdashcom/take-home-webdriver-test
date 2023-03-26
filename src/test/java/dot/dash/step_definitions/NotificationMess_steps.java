package dot.dash.step_definitions;

import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class NotificationMess_steps {
    @Then("verify one of following messages is displayed")
    public void verify_one_of_following_messages_is_displayed(List<String> list) {
        String actualMess = Driver.getDriver().findElement(By.id("flash")).getText().replace("×", " ").trim();

        Assert.assertTrue(list.stream().anyMatch(m -> m.equals(actualMess)));

    }
}
