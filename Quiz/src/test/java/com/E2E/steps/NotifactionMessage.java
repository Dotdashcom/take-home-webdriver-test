package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotifactionMessage {
@Given("the user is on the notifaction page")
public void the_user_is_on_the_notifaction_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/notification_message_rendered");
}

@When("Test clicks on the Click Here link a multiple times")
public void test_clicks_on_the_Click_Here_link_a_multiple_times() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click();
    TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click();
    TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click();
    TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click();


}
@Then("Test asserts that one of the notifaction is displayed")
public void test_asserts_that_one_of_the_notifaction_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
    WebElement notifaction = TestRunner.driver.findElement(By.xpath("//*[@id='flash']"));

    if(notifaction.getText().contains("Action unsuccesful, please try again")){
        Assert.assertTrue(true);
    }else if(notifaction.getText().contains("Action successful")){
        Assert.assertTrue(true);
    
    } else if(notifaction.getText().equals("Action Unsuccessful")){
        Assert.assertTrue(true);
    }else {
        Assert.assertTrue(false);
    }
}
}
