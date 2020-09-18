package stepDefs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;



import io.cucumber.java.en.*;
import utils.Driver;

public class ContextMenu {
	
	
	@Given("I am on the context menu page")
	public void i_am_on_the_context_menu_page() {
		Driver.getDriver().get("http://localhost:7080/context_menu");
	}

	@When("I right click on the context menu")
	public void i_right_click_on_the_context_menu() {
		Actions action = new Actions(Driver.getDriver());
		action.contextClick(Driver.getDriver().findElement(By.xpath("//*[@id='hot-spot']"))).build().perform();
	}

	@Then("I varify the alert menu text")
	public void i_varify_the_alert_menu_text() {
		String alerText = "You selected a context menu";
		String actualAlerText = Driver.getDriver().switchTo().alert().getText();
		System.out.println(actualAlerText);
		assertEquals(alerText, actualAlerText);
	}

}
