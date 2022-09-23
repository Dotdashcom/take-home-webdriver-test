package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.CommonMethods;

public class DynamicContentSteps extends CommonMethods {
	
	public static String firstRowText;
	public static String secondRowText;
	public static String thirdRowText;

	@Given("I navigate to the page and get the content")
	public void i_navigate_to_the_page_and_get_the_content() {
		navigateToEndPointPage("dynamic_content");
		 wait(3);
				
	}

	@Then("I refresh the page and validate content is changed")
	public void i_refresh_the_page_and_validate_content_is_changed() {
		
		firstRowText = dynamicContent.firstText.getText();
		secondRowText = dynamicContent.secondText.getText();
		thirdRowText = dynamicContent.thirdText.getText();
		
		driver.navigate().refresh();

		Assert.assertNotEquals("Uh-oh... Content is the same", firstRowText, secondRowText);
		System.out.println("Content does not match!");

		driver.navigate().refresh();
		
		Assert.assertNotEquals("Uh-oh... Content is the same", firstRowText, thirdRowText);
		System.out.println("Content does not match!");
		
		driver.navigate().refresh();

		Assert.assertNotEquals("Uh-oh... Content is the same", secondRowText, thirdRowText);
		System.out.println("Content does not match!");

	}

}
