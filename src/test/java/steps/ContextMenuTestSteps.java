package steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testbase.BaseClass;
import utils.CommonMethods;
import utils.ConfigsReader;

public class ContextMenuTestSteps extends CommonMethods {

	@Given("I right click on box")
	public void i_right_click_on_box() {

		BaseClass dr = new BaseClass();

		dr.driver.get(ConfigsReader.getProperty("url") + "/context_menu");

		wait(2);

		Actions action = new Actions(driver);
		action.contextClick(contextMenu.contextBox).perform();
		wait(1);

	}

	@Then("I validate context menu showed up")
	public void i_validate_context_menu() {

		String alertText = driver.switchTo().alert().getText();
		Alert alert = driver.switchTo().alert();

		Assert.assertFalse("Alert is not displayed...", alertText.isBlank());
		wait(3);
		
		alert.accept();
		System.out.println("Alert is visible!");

	}

}
