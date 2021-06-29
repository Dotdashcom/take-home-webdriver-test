package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.CheckboxPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import com.new_york_remote.utilities.HelperMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckboxStepDefs {
    HelperMethods helperMethods;
CheckboxPage checkboxPage=new CheckboxPage();
    @Given("user is on the checkbox page")
    public void user_is_on_the_checkbox_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/checkboxes ");
    }




    @When("user click the checkbox1")
    public void user_click_the_checkbox1() {

        if(!checkboxPage.checkbox1.isSelected()){
        checkboxPage.checkbox1.click();}
        else{
            Assert.assertTrue(checkboxPage.checkbox1.isSelected());
        }



    }
    @Then("checkbox1 is selected")
    public void checkbox1_is_selected() {
        Assert.assertTrue(checkboxPage.checkbox1.isSelected());
    }







    @When("user click the checkbox2")
    public void user_click_the_checkbox2() {
        if(!checkboxPage.checkbox2.isSelected()){
            checkboxPage.checkbox2.click();}
        else{
            Assert.assertTrue(checkboxPage.checkbox2.isSelected());
        }


    }
    @Then("checkbox2 is selected")
    public void checkbox2_is_selected() {
        Assert.assertTrue(checkboxPage.checkbox2.isSelected());
    }




}
