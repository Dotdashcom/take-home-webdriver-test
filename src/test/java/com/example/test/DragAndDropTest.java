package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.example.test.util.TestUtil;

public class DragAndDropTest {

	WebDriver driver;
	TestUtil testUtil = new TestUtil();

	@Before
	public void setUp() {
		// Set the path to the ChromeDriver executable
		try {
			System.setProperty(testUtil.getDriverName(), testUtil.getDriverPath());
			driver = testUtil.getDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// Handle exception if WebDriver setup fails
			System.out.println("Exception occurred while setting up WebDriver: " + e.getMessage());
		}
	}

	@After
	public void tearDown() {
		try {
			// Close the browser and clean up resources
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			// Handle exception if browser closure fails
			System.out.println("Exception occurred during browser closure: " + e.getMessage());
		}
	}

	@Test
	public void dragAndDropTest() {

		try {
			// Navigate to the login page
			driver.get("http://localhost:7080/drag_and_drop");

			WebElement columnA = driver.findElement(By.id("column-a"));
			WebElement columnB = driver.findElement(By.id("column-b"));

			// Create an instance of Actions class
			String headerA = columnA.findElement(By.tagName("header")).getText();
			String headerB = columnB.findElement(By.tagName("header")).getText();
			assertEquals(headerA, "A");
			assertEquals(headerB, "B");
			// Perform drag and drop operation
			String script = "function createEvent(typeOfEvent) {\n" +
	                "    var event = document.createEvent(\"CustomEvent\");\n" +
	                "    event.initCustomEvent(typeOfEvent, true, true, null);\n" +
	                "    event.dataTransfer = {\n" +
	                "        data: {},\n" +
	                "        setData: function (key, value) {\n" +
	                "            this.data[key] = value;\n" +
	                "        },\n" +
	                "        getData: function (key) {\n" +
	                "            return this.data[key];\n" +
	                "        }\n" +
	                "    };\n" +
	                "    return event;\n" +
	                "}\n" +
	                "\n" +
	                "function dispatchEvent(element, event, transferData) {\n" +
	                "    if (transferData !== undefined) {\n" +
	                "        event.dataTransfer = transferData;\n" +
	                "    }\n" +
	                "    if (element.dispatchEvent) {\n" +
	                "        element.dispatchEvent(event);\n" +
	                "    } else if (element.fireEvent) {\n" +
	                "        element.fireEvent(\"on\" + event.type, event);\n" +
	                "    }\n" +
	                "}\n" +
	                "\n" +
	                "function simulateHTML5DragAndDrop(element, target) {\n" +
	                "    var dragStartEvent = createEvent('dragstart');\n" +
	                "    dispatchEvent(element, dragStartEvent);\n" +
	                "    var dropEvent = createEvent('drop');\n" +
	                "    dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);\n" +
	                "    var dragEndEvent = createEvent('dragend');\n" +
	                "    dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);\n" +
	                "}\n" +
	                "\n" +
	                "var sourceElement = arguments[0];\n" +
	                "var targetElement = arguments[1];\n" +
	                "simulateHTML5DragAndDrop(sourceElement, targetElement);";

	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript(script, columnA, columnB);

			// Get the final text of the headers
			String finalHeaderA = columnA.findElement(By.tagName("header")).getText();
			String finalHeaderB = columnB.findElement(By.tagName("header")).getText();

			// Assert the changes in the headers after drag and drop
			assertEquals(headerA, finalHeaderB);
			assertEquals(headerB, finalHeaderA);
		} catch (Exception e) {
			// Handle exception if the test encounters an error
			System.out.println("Exception occurred during login test: " + e.getMessage());
		}
	}

}
