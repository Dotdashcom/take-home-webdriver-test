package com.theInternet.StepDefinitions;

import com.theInternet.Pages.dropDownPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class dropDownSrepDefs {

    dropDownPage dropDownPage = new dropDownPage();
    List<WebElement> options;
    @Given("User on Drop Down page")
    public void user_on_Drop_Down_page() {
        System.out.println("Opening the Drop Down page");
        Driver.get().get(ConfigurationReader.get("baseURL") + "dropdown");
    }

    @When("User selects Option {int} and Option {int} from the drop down menu")
    public void user_selects_Option_and_Option_from_the_drop_down_menu(Integer int1, Integer int2) {
        Select select = new Select(dropDownPage.options);
        options = select.getOptions();
    }

    @Then("Option {int} and Option {int} are selected")
    public void option_and_Option_are_selected(Integer int1, Integer int2) {
        if(options.get(int1).isSelected()){
            assertThat(options.get(int1).getText(), is("Option 1"));
        }else if(options.get(int1).isSelected()){
            assertThat(options.get(int2).getText(), is("Option 2"));
        }

    }
}
