package resources.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import resources.pages.ContextMenuPages;
import resources.utilities.BaseClass;

public class ContextMenuStep extends BaseClass{

    @Given("User launches the contextMenu page")
    public void userLaunchesTheContextMenu() {
        BaseClass tb= new BaseClass();
        String addPath="context_menu";
        tb.setupDownload(addPath);
    }

    @When("User clicks on contextMenuBox")
    public void clickContextMenu() {
        ContextMenuPages cm= new ContextMenuPages();
        cm.rightClickCxtBox();
    }

    @And("User verify the text on the JS Alert")
    public void checkTextOnJSAlert() {
        ContextMenuPages cm= new ContextMenuPages();
        String contextText=cm.getTextOnAlert();
        Assert.assertEquals( contextText,prop.getProperty("CxtMenuAlertText"));
    }
}
