package steps;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testbase.BaseClass;
import utils.CommonMethods;
import utils.ConfigsReader;

public class DragAndDropTestSteps extends CommonMethods {

	@Given("I drag box A and drop in box B")
	public void i_drag_box_a_and_drop_in_box_b() {
		BaseClass dr = new BaseClass();

		dr.driver.get(ConfigsReader.getProperty("url") + "/drag_and_drop");

		Actions actions = new Actions(driver);

		actions.dragAndDrop(dragger.box_a, dragger.box_b).perform();
		
		wait(3);
		
	}

	@Then("I validate that box A is in box B")
	public void i_validate_that_box_a_is_in_box_b() {
		
		String expectedResult = "A";
		Assert.assertEquals("Cannot drag and drop...", expectedResult, dragger.box_b_text.getText());
		System.out.println("I was able to drag box A to box B!");
	}

}
