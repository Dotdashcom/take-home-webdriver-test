package steps;

import base.Functions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MouseHoverPageSteps extends Functions {

    public static List<String> actualNames = new ArrayList<>();

    @When("user hovers on every users avatar")
    public void user_hovers_on_every_users_avatar() {

        List<WebElement> names = mouseHoverPage.names;
        Iterator<WebElement> itNames = names.iterator();
        while (itNames.hasNext()) {
            for (WebElement avatar : mouseHoverPage.avatarsList) {
                hoverMouse(waitForVisibility(avatar));
                actualNames.add(waitForVisibility(itNames.next()).getText().replace("name: ", ""));
            }
        }
    }

    @Then("user sees additional information under Avatar")
    public void user_sees_additional_information_under_Avatar(DataTable dataTable) {

        List<String> expectedNames = dataTable.asList();
        Assert.assertEquals(expectedNames, actualNames);
    }

    @When("user clicks on the profile link")
    public void user_clicks_on_the_profile_link() {

        hoverMouse(mouseHoverPage.firstAvatar);
        click(mouseHoverPage.firstProfileLink);
    }

    @Then("user sees message {string}")
    public void user_sees_message(String expectedMessage) {

        Assert.assertEquals(expectedMessage, mouseHoverPage.actualMessage.getText());
    }

}