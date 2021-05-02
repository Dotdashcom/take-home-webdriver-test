package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.FloatinMenuPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class US11_step_definition {
    private FloatinMenuPage floatinMenuPage = new FloatinMenuPage();

    @Given("navigate to Floating Menu")
    public void navigate_to_floating_menu() {
        floatinMenuPage.floatingMenu.click();
    }


    @When("scroll down")
    public void scroll_down() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", floatinMenuPage.eSLink);
    }

    @Then("verify Floating Menu is displayed")
    public void verify_floating_menu_is_displayed() {
        Assert.assertTrue(floatinMenuPage.menu.isEnabled());
        Assert.assertTrue(floatinMenuPage.menu.isDisplayed());
    }
}
