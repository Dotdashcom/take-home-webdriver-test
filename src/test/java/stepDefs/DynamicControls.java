package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DynamicControls {
	@Given("I am on the Dynamic Controls page")
	public void i_am_on_the_Dynamic_Controls_page() {
		Driver.getDriver().get("http://localhost:7080/dynamic_controls");
		Driver.getDriver().manage().window().maximize();
	}

	@When("I click on the Remove Button")
	public void i_click_on_the_Remove_Button() {
Driver.getDriver().findElement(By.xpath("//button[text()='Remove']")).click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));

	}

	@Then("I verify the checkbox is gone")
	public void i_verify_the_checkbox_is_gone() {
String expected = "It's gone!";
String actual = Driver.getDriver().findElement(By.id("message")).getText();
assertEquals(expected,actual);
System.out.println("The Checkbox " + actual);
		System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());
	}

	@When("I click Add Button")
	public void i_click_Add_Button() {
      Driver.getDriver().findElement(By.xpath("//button[text()='Add']")).click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));
	}

	@Then("I assert that the checkbox is present")
	public void i_assert_that_the_checkbox_is_present() {
String expected="It's back!";
String actualtext =Driver.getDriver().findElement(By.id("message")).getText();
		assertEquals(expected,actualtext);
		System.out.println("The Checkbox " + actualtext);
		System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());
	}

	@When("I click on the Enanble Button")
	public void i_click_on_the_Enanble_Button() {
Driver.getDriver().findElement(By.xpath("//button[text()='Enable']")).click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
	}

	@Then("I assert that the text box is enabled")
	public void i_assert_that_the_text_box_is_enabled() {
String expected = "It's enabled!";
String actualtext = Driver.getDriver().findElement(By.id("message")).getText();
		assertEquals(expected,actualtext);
		System.out.println("The text box " + actualtext);
		System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());
	}

	@When("I click on the Disable Button")
	public void i_click_on_the_Disable_Button() {
		Driver.getDriver().findElement(By.xpath("//button[text()='Disable']")).click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enable']")));
	}

	@Then("I assert that the box is disabled")
	public void i_assert_that_the_box_is_disabled() {
		String expected = "It's disabled!";
		String actualtext = Driver.getDriver().findElement(By.id("message")).getText();
		Driver.getDriver().findElement(By.id("message")).isDisplayed();
		assertEquals(expected,actualtext);
		System.out.println("The text box " + actualtext);
		System.out.println(Driver.getDriver().findElement(By.id("message")).isDisplayed());
	}
}
