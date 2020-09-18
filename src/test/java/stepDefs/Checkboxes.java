package stepDefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

public class Checkboxes {

	
	@Given("I am on the checkbox page")
	public void i_am_on_the_checkbox_page() {
		Driver.getDriver().get("http://localhost:7080/checkboxes");
	}
	

	@Then("I varify checks and unchecks checkboxes")
	public void i_varify_checks_and_unchecks_checkboxes() {
	
	List <WebElement> list = Driver.getDriver().findElements(By.xpath("//*[@id=\"checkboxes\"]/input"));
			
			boolean flag = false;
			String checkbox = "not Selected";
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).isSelected()) {
					checkbox="selected";
				}
				System.out.println(checkbox);
				
				checkbox = "not Selected";
		}
}}
