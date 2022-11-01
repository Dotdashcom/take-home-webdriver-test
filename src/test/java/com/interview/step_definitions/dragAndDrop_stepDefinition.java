package com.interview.step_definitions;

import com.interview.pages.DragAndDropPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop_stepDefinition {
DragAndDropPage dragAndDropPage=new DragAndDropPage();
    @Given("user is on the drag and drop page")
    public void user_is_on_the_drag_and_drop_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/drag_and_drop");
    }



    @When("user drag A to drop B")
    public void user_drag_a_to_drop_b() {
        Actions actions = new Actions(Driver.getDriver());
        if(dragAndDropPage.columnA.getText().equals("A")){
actions.dragAndDrop(dragAndDropPage.columnA, dragAndDropPage.columnB).perform();}
       else{
            actions.dragAndDrop(dragAndDropPage.columnB, dragAndDropPage.columnA).perform();
        }


    }
    @Then("A and B is switched")
    public void a_and_b_is_switched() {
        System.out.println("dragAndDropPage.columnA.getText() = " + dragAndDropPage.columnA.getText());

        if (dragAndDropPage.columnA.getText().equals("B")) {

            Assert.assertTrue(dragAndDropPage.columnA.getText().equals("B"));
        }else{
            Assert.assertTrue(dragAndDropPage.columnA.getText().equals("A"));
        }

    }
}
