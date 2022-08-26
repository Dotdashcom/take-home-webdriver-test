package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContextMenu {


@Given("the user is on the page")
public void the_user_is_on_the_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/context_menu");
}


@When("the user clicks the box to open context menu")
public void the_user_clicks_the_box_to_open_context_menu() {
    // Write code here that turns the phrase above into concrete actions
    Actions elementtoclick = new Actions(TestRunner.driver);
    elementtoclick.moveToElement(TestRunner.driver.findElement(By.id("hot-spot"))).
      contextClick().
      build().perform();


}
@Then("then it will trigger a alert")
public void then_it_will_trigger_a_alert() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.wait.until(ExpectedConditions.alertIsPresent());
    Alert alert = TestRunner.driver.switchTo().alert();
    Assert.assertEquals("You selected a context menu", alert.getText());
    TestRunner.driver.switchTo().alert().accept();

}
    
}
