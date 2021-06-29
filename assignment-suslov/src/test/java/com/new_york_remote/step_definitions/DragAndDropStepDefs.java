package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.DragAndDropPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropStepDefs {
DragAndDropPage dragAndDropPage=new DragAndDropPage();
    @Given("user is on the drag and drop page")
    public void user_is_on_the_drag_and_drop_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
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
