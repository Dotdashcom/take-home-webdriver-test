package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationMessage extends BaseTest {

    @Given("I navigate to the Notification Message Page")
    public void iNavigateToTheNotificationMessagePage() throws Exception {
        notificationMessagePage.navigateToNotificationMessagePage();
    }

    @When("I click on the notification generator link")
    public void iClickOnTheNotificationGeneratorLink() throws Exception {
        notificationMessagePage.clickOnNotificationGeneratorLink();
    }

    @Then("I should see the the proper message")
    public void iShouldSeeTheTheProperMessage() throws InterruptedException {
        notificationMessagePage.validateNotificationMessage();
    }
}

