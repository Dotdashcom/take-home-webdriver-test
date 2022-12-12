package com.company.step_definitions;

import com.company.pages.GoogleSearchPage;
import com.company.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleSearch {

    GoogleSearchPage googleSearchPage =new GoogleSearchPage();

    @When("User searches for {string} capital")
    public void user_searches_for_capital(String countryName) {
        googleSearchPage.searchBox.sendKeys("what is capital of "+countryName + Keys.ENTER);
    }

    @Then("User should see {string} in the result")
    public void user_should_see_in_the_result(String capitalCity) {

      Assert.assertEquals(capitalCity,googleSearchPage.capitalText.getText());

    }









    @Then("User should be able to search for following:")
    public void user_should_be_able_to_search_for_following(List<String> searchKeywords) {
        System.out.println("searchKeywords: " + searchKeywords);

        for (String each : searchKeywords) {
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(each+Keys.ENTER);
            Assert.assertEquals(each+" - Google Search",Driver.getDriver().getTitle());
        }

    }






    @Given("User is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com/");

    }
    @When("User types apple in the google search box and clicks enter")
    public void user_types_apple_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);

    }
    @Then("User sees apple – Google Search is in the google title")
    public void user_sees_apple_google_search_is_in_the_google_title() {

        Assert.assertEquals("Title verification is failed!","apple - Google Search",Driver.getDriver().getTitle());

    }


    @When("User types {string} in the google search box and clicks enter")
    public void userTypesInTheGoogleSearchBoxAndClicksEnter(String searchKeyword) {

        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);


    }



    @Then("User sees {string} is in the google title")
    public void userSeesIsInTheGoogleTitle(String expectedTitle) {

        Assert.assertEquals("Title verification is failed!",expectedTitle,Driver.getDriver().getTitle());
      //TODO: you need to fix this later

    }



}
