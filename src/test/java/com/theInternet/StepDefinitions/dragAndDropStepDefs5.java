package com.theInternet.StepDefinitions;

import com.theInternet.Pages.dragAndDropPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;

public class dragAndDropStepDefs5 {
    Actions actions;
    dragAndDropPage dragAndDropPage = new dragAndDropPage();

    @Given("User on Drag and Drop page")
    public void user_on_Drag_and_Drop_page() {
        System.out.println("Opening the Checkboxes page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"drag_and_drop");
        Driver.get().manage().window().fullscreen();
    }

    @When("User drags element A to element B")
    public void user_drags_element_A_to_element_B() {
        actions = new Actions(Driver.get());
        actions.dragAndDrop(dragAndDropPage.boxA, dragAndDropPage.boxB).build().perform();
        //actions.moveToElement(dragAndDropPage.boxA).clickAndHold().moveToElement(dragAndDropPage.boxB).release().build().perform();
    }

    @Then("text on element A and B are switched")
    public void text_on_element_A_and_B_are_switched() {
        String a = "A";
        String b = "B";

//        assertThat(dragAndDropPage.boxA.getText(), equalTo(b));
//        assertThat(dragAndDropPage.boxB.getText(), equalTo(a));

    }
}
