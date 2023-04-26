package resources.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.pages.DragAndDropPages;
import resources.utilities.BaseClass;
import java.awt.*;

public class DragAndDropStep extends BaseClass{

    @Given("User launches the drag and drop page")
    public void userLaunchesTheDragAndDrop() {
        BaseClass tb= new BaseClass();
        String addPath="drag_and_drop";
        tb.setupDownload(addPath);
    }

    @And("User verifies text on ElementA and ElementB")
    public void verifyTextBeforeSwitch() {
    }
    @When("User drags ElementA to ElementB")
    public void drgdrp() throws InterruptedException, AWTException {
        DragAndDropPages dd = new DragAndDropPages();
        dd.drgAndrop();
    }
    @Then("Verify the switched text on ElementA and ElementB")
    public void switchText() {
    }

}
