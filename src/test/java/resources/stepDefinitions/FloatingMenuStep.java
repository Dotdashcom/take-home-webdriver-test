package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.FloatingMenuPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class FloatingMenuStep extends BaseClass{

    @Given("User launches the floating menu page")
    public void userLaunchesTheFloatingMenu() {
        BaseClass tb= new BaseClass();
        String addPath="floating_menu";
        tb.setupDownload(addPath);
    }
    @And("User checks whether the floating menu is visible")
    public void checkFloatingMenu() {
        FloatingMenuPages fm= new FloatingMenuPages();
        boolean flag=fm.usercheckFloatingMenu();
        Assert.assertTrue(flag);
    }

    @And("User scrolls to the bottom of the page")
    public void scrollToBottom() {
        FloatingMenuPages fm= new FloatingMenuPages();
        fm.userscrollToBottom();
    }
}
