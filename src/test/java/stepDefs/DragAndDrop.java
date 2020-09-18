package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



import io.cucumber.java.en.*;
import utils.Driver;

public class DragAndDrop {
	@Given("I am on the drag and drop page")
	public void i_am_on_the_drag_and_drop_page() {
		Driver.getDriver().get("http://localhost:7080/drag_and_drop");
		Driver.getDriver().manage().window().maximize();
	}

	@When("I drag element A to element B")
	public void i_drag_element_A_to_element_B() {
		Actions action = new Actions(Driver.getDriver());
		WebElement source = Driver.getDriver().findElement(By.xpath("//div[@id='column-a']"));
		WebElement target = Driver.getDriver().findElement(By.xpath("//div[@id='column-b']"));
		action.dragAndDrop(target, source).build().perform();
	//	
//		action.clickAndHold(source)
//		   .moveToElement(target)
//		   .release(target)
//		   .build().perform();
	}

	@Then("I verify the text on element A and B are switched")
	public void i_verify_the_text_on_element_A_and_B_are_switched() {
	
	}
	

	
}
