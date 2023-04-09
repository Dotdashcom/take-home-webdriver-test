package com.internet.stepdefinitions;

import com.internet.pages.NotificationPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class NotificationStepDefinitions {

    NotificationPage notificationPage = new NotificationPage();

    @Then("User observes the notifications are displayed")
    public void userObservesTheNotificationsAreDisplayed(){
        Assertions.assertTrue(notificationPage.atleastOnce()>2);
    }
}
