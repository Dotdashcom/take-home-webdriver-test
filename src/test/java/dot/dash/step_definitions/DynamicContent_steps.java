package dot.dash.step_definitions;

import dot.dash.pages.Dynamic;
import dot.dash.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DynamicContent_steps {
    Dynamic dy = new Dynamic();
    List<String>  list = new ArrayList<>();
    @When("user must see <{int}> paragraph of text")
    public void user_must_see_paragraph_of_text(Integer num) {

        for (int i = 1; i <= num; i++) {
            Assert.assertTrue(dy.getParagraph(i).isDisplayed());
        }
        list = dy.listOfTexts();
    }
    @When("user does refresh the page <{int}> times each time content must change")
    public void user_does_refresh_the_page_times_each_time_content_must_change(Integer num) {
        for (int i = 1; i <= num; i++) {
            Driver.getDriver().navigate().refresh();
            List<String> newTexts = dy.listOfTexts();
            for (int j = 0; j < newTexts.size(); j++) {
                Assert.assertNotEquals(newTexts.get(j), list.get(j));
            }
            list = dy.listOfTexts();
        }
    }
}
