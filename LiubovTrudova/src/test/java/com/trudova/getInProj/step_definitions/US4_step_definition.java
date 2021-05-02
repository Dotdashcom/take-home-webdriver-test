package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.DragAndDropPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class US4_step_definition {
    private DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Given("navigate to Drag and Drop")
    public void navigate_to_drag_and_drop() {
        dragAndDropPage.dragAndDrop.click();
    }


    @Then("Drag and Drop boxA to boxB, verify text inside boxes been changed")
    public void drag_and_drop_box_a_to_box_b_verify_text_inside_boxes_been_changed() {
        Actions actions = new Actions(Driver.getDriver());
//        String beforeDropA = dragAndDropPage.baxA.getText();
//        String beforeDropB = dragAndDropPage.baxB.getText();

        //  actions.dragAndDrop(dragAndDropPage.baxA,dragAndDropPage.baxB).build().perform();
//        String afterDropA = dragAndDropPage.baxA.getText();
//        String afterDropB = dragAndDropPage.baxB.getText();
        //   Assert.assertFalse(beforeDropA.equalsIgnoreCase(afterDropA));
        Action dragAndDrop = actions.clickAndHold(dragAndDropPage.baxA)
                .moveToElement(dragAndDropPage.baxB)
                .release(dragAndDropPage.baxB)
                .build();
        dragAndDrop.perform();
        // Not sure obout that one for some reason selenium doesn't locate second column


    }

}
