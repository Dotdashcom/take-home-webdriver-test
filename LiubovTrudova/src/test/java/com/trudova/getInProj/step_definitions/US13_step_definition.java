package com.trudova.getInProj.step_definitions;


import com.trudova.getInProj.pages.MouseHoverPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class US13_step_definition  {
    private MouseHoverPage mouseHoverPage = new MouseHoverPage();
    @Given("navigate to Mouse Hover")
    public void navigate_to_mouse_hover() {
        mouseHoverPage.hovers.click();
    }


    @Then("hover over image,verify additional information is displayed")
    public void hover_over_image_verify_additional_information_is_displayed() {
        Actions actions = new Actions(Driver.getDriver());
        List<WebElement> information= mouseHoverPage.listInfo;
        List<WebElement> imgs = mouseHoverPage.listImg;
        for (int i = 0; i < imgs.size(); i++) {
            actions.moveToElement(imgs.get(i)).perform();
            boolean result = information.get(i).isDisplayed();
            Assert.assertTrue(result);
        }
    }

}
