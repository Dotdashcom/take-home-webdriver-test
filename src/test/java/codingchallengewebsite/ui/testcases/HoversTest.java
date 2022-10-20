package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class HoversTest extends UITests {

    public HoversTest() {
    }

    @Test(description = "Validates behaviour on mouse over")
    public void validateHoverAndUserDetails() {
        HoversPage hoversPage = new HoversPage(this.driver, this);
        Map.Entry<String, String> firstEntry = null;
        boolean result;
        Assert.assertTrue(hoversPage.isPageOpen(), "Page not open");

        // On a current user
        firstEntry = hoversPage.usersDetails.entrySet().stream().findFirst().get();
        String username = firstEntry.getKey();
        String profilePhoto = firstEntry.getValue();
        result = hoversPage.validateHoverOverFigure(username, profilePhoto);
        Assert.assertTrue(result, "Hover isn't working as expected");

        // On a fake user
        result = hoversPage.validateHoverOverFigure("John Doe", "myFunPic.png");
        Assert.assertFalse(result, "Hover shouldn't be working, but it is");
    }
}
