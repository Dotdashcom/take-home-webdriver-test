package com.interview.step_definitions;

import com.interview.pages.DropDownPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropDown_stepDefinition {
DropDownPage dropDownPage=new DropDownPage();
    @Given("user is on the DropDown page")
    public void user_is_on_the_drop_down_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/dropdown");
    }




    @When("user select Option1 and Option2")
    public void user_select_option1_and_option2() {
        Select select=new Select(dropDownPage.dropDownBox);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions) {
            eachOption.click();
            Assert.assertTrue(eachOption.isSelected());
        }
    }
    @Then("Option1 and Option2 is selected")
    public void option1_and_option2_is_selected() {

    }
}
