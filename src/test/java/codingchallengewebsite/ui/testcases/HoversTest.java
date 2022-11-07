package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class HoversTest extends UITest {

    public HoversTest() { }

    @Test(description = "Validates behaviour on mouse over")
    public void validateHoverAndUserDetails() {
        HoversPage hoversPage = new HoversPage(this);
        Map.Entry<String, String> firstEntry = null;
        Boolean hoverValidation;

        // Validate page loaded
        Assert.assertTrue(hoversPage.isPageOpen(), "Page not open");
        // Select user from page
        firstEntry = hoversPage.getUsersDetails().entrySet().stream().findFirst().get();
        String username = firstEntry.getKey();
        String profilePhoto = firstEntry.getValue();
        // Hover over user
        hoverValidation = hoversPage.validateHoverOverFigure(username, profilePhoto);
        // Validate information displayed
        Assert.assertTrue(hoverValidation, "Hover isn't working as expected");
        // Make up a fake user
        hoverValidation = hoversPage.validateHoverOverFigure("John Doe", "myFunPic.png");
        // Validate information not displayed
        Assert.assertFalse(hoverValidation, "Hover shouldn't be working, but it is");
    }
}