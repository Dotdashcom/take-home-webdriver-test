package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverSteps {

    @Then("I mouse hover, assert that additional info is displayed")
    public void i_mouse_hover_assert_that_additional_info_is_displayed() {
        Actions action = new Actions(Driver.get());


        for(int i=1; i<=3; i++){
            action.moveToElement(Driver.get().findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();

            WebElement textOfImage = Driver.get().findElement(By.cssSelector(".figure:nth-of-type("+i+") h5"));
            String actualResult = textOfImage.getText();
            String expectedResult = "name: user"+i;

            Assert.assertEquals(actualResult,expectedResult);
            Assert.assertTrue(textOfImage.isDisplayed());
        }
    }
}
