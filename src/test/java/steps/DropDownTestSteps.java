package steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testbase.BaseClass;
import utils.CommonMethods;
import utils.ConfigsReader;

public class DropDownTestSteps extends CommonMethods {
	
	@Given("I verify drop down")
	public void i_verify_drop_down() {
	   
		BaseClass dr = new BaseClass();

		dr.driver.get(ConfigsReader.getProperty("url") + "/dropdown");
		
		click(dropDowner.dropDown);
		Assert.assertTrue("Drop down option is not visible...", dropDowner.dropDown.isDisplayed());
		System.out.println("Drop down is selectable!");
		wait(1);
		click(dropDowner.dropDown);
		
		
		
		wait(2);
	}

	@Then("I validate drop down options are selectable")
	public void i_validate_drop_down_options_are_selectable() {
	    
		Select select = new Select(dropDowner.dropDown);
		
		selectDropdown(dropDowner.dropDown, "Option 1");
		String expected_1 = "Option 1";
		Assert.assertEquals("Option 1 was not selected...", expected_1, select.getFirstSelectedOption().getText());
		System.out.println(expected_1 + " was selected!");
		
		wait(2);
		
		selectDropdown(dropDowner.dropDown, "Option 2");
		String expected_2 = "Option 2";
		Assert.assertEquals("Option 2 was not selected...", expected_2, select.getFirstSelectedOption().getText());
		System.out.println(expected_2 + " was selected!");
		
		System.out.println("Drop down is validated!");
	}

}
