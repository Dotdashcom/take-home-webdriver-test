package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.DropdownPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownStepDefs {
DropdownPage dropDownPage=new DropdownPage();
    @Given("user is on the DropDown page")
    public void user_is_on_the_drop_down_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
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
