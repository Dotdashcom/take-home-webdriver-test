package dot.dash.step_definitions;

import dot.dash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class NewTab_steps {
    WebDriver driver = Driver.getDriver();

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String link) {

        driver.findElement(By.linkText(link)).click();

    }

    @Then("verify the link will be open in new tab")
    public void verify_the_link_will_be_open_in_new_tab(String header) {
        Set<String> wh = driver.getWindowHandles();

        for (String s : wh) {
            driver.switchTo().window(s);
            if (driver.getTitle().equals(header)) {
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(), header);

    }
}
