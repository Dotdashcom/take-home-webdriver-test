package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testbase.BaseClass;
import utils.CommonMethods;
import utils.ConfigsReader;

public class CheckBoxTestSteps extends CommonMethods {
	
	@Given("I click on checkbox1")
	public void i_click_on_checkbox1() {

		BaseClass dr = new BaseClass();
		dr.driver.get(ConfigsReader.getProperty("url") + "/checkboxes");

		wait(1);
		click(checkBoxes.checkbox1);
		wait(1);
		click(checkBoxes.checkbox1);
		wait(1);
		click(checkBoxes.checkbox1);
	}
	
	@And("I click on checkbox2")
	public void i_click_on_checkbox2() {

		wait(1);
		click(checkBoxes.checkbox2);
		wait(1);
		click(checkBoxes.checkbox2);
		
	}

	@Then("I validate both checkboxes are clickable")
	public void i_validate_both_checkboxes_are_clickable() {

		wait(3);

		Assert.assertTrue("Checkbox 1 is not selectable...",
				checkBoxes.checkbox1.isSelected());
		System.out.println("Checkbox 1 was selected!");
		
		Assert.assertTrue("Checkbox 2 is not selectable...",
				checkBoxes.checkbox2.isSelected());
		System.out.println("Checkbox 2 was selected!");
	}

}
