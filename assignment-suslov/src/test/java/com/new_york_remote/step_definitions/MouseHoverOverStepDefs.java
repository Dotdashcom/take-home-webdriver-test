package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.MouseHoverPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHoverOverStepDefs {
MouseHoverPage mouseHoverPage =new MouseHoverPage();
    Actions actions = new Actions(Driver.getDriver());
    @Given("user is on the Mouse Hover page")
    public void user_is_on_the_mouse_hover_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/hovers");
    }




    @When("mouse hover on each image")
    public void mouse_hover_on_each_image() {
List<WebElement>images= mouseHoverPage.images;
        for (WebElement eachImage : images) {
            actions.moveToElement(eachImage).perform();

        }
    }
    @Then("additional information is displayed for each image.")
    public void additional_information_is_displayed_for_each_image() {
        System.out.println("hoverPage.texts1.getText() = " + mouseHoverPage.texts3.getText());
//Assert.assertTrue(hoverPage.texts1.getText().equals("name: user1"));
//        Assert.assertTrue(hoverPage.texts2.getText().equals("name: user2"));
       Assert.assertTrue(mouseHoverPage.texts3.getText().equals("name: user3"));
    }

}
