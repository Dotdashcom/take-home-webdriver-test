package com.rtr.steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.rtr.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class DragAndDropTestSteps extends CommonMethods {

	@Given("I navigated to Drag and Drop website")
	public void i_navigated_to_drag_and_drop_website() {
		setUp("/drag_and_drop");
		wait(2);

	}

	@When("I Drag A to Drop on B")
	public void i_drag_a_to_drop_on_b() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				dragAndDropPageElements.boxa, dragAndDropPageElements.boxb);
	}

	@Then("I assert the text on element A and B switched")
	public void i_assert_the_text_on_element_a_and_b_switched() {

		String firtExpectedLetter = "B";
		String secondExpectedLetter = "A";

		String firstActualLetterString = dragAndDropPageElements.firstletter.getText();
		String secondActualLetterString = dragAndDropPageElements.secondletter.getText();

		Assert.assertEquals(firtExpectedLetter, firstActualLetterString);
		Assert.assertEquals(secondExpectedLetter, secondActualLetterString);

	}

}
