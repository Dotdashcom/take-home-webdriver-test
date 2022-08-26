package com.E2E.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenNewTab {
@Given("the user is on the opennewtab page")
public void the_user_is_on_the_opennewtab_page() {
    // goes to site
    TestRunner.driver.get("http://localhost:7080/windows");
}


@When("Test clicks on the Click Here link")
public void test_clicks_on_the_Click_Here_link() {
// clicks open new window
TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/a")).click();

}
@Then("Test asserts that a new tab is opened with text New Window")
public void test_asserts_that_a_new_tab_is_opened_with_text_New_Window() {
    //Creates a list of all the windows
    List<String> browserTabs = new ArrayList<String> (TestRunner.driver.getWindowHandles());
    //Switches to second tab
    TestRunner.driver.switchTo().window(browserTabs .get(1));
    //checks title of the new tab
    Assert.assertEquals("New Window", TestRunner.driver.getTitle());
    //close tab
    TestRunner.driver.close();
    // ensures we are back on the first tab
    TestRunner.driver.switchTo().window(browserTabs.get(0));
}
    
}
