package com.internet.stepdefinitions;

import com.internet.pages.MouseHoverPage;
import io.cucumber.java.en.When;

public class MouseHoverStepDefinitions {

    MouseHoverPage mouseHoverPage = new MouseHoverPage();

    @When("User mouse hover on the images User observes informations")
    public void userMouseHoverOnTheImagesUserObservesInformations() {
        mouseHoverPage.checkListOfAvatar();
    }
}
