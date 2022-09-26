package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class DragAndDrop extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateDragandDrop() throws InterruptedException {
		// locate and click on drag and drop link
		WebElement drgDrp_link = driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(drgDrp_link));
		drgDrp_link.click();

		// verify if drag and drop page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/drag_and_drop";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		WebElement source = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='column-b']"));
		// before drag and drop
		String txt1 = source.getText();
		System.out.println("Text at position 1 is " + txt1);
		String txt2 = destination.getText();
		System.out.println("Text at position 2 is " + txt2);

		/*
		 * injecting JavascriptExecutor interface because it's a standard HTML5 page and
		 * it won't work in selenium without some additional work to trigger specific JS
		 * callbacks
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", source, destination);
		Thread.sleep(1000);

		// after drag and drop
		String act_drgNdrpTxt1 = source.getText();
		String exp_drgNdrpTxt1 = "B";
		System.out.println("Text at position 1 is " + act_drgNdrpTxt1);
		String act_drgNdrpTxt2 = destination.getText();
		String exp_drgNdrpTxt2 = "A";
		System.out.println("Text at position 2 is " + act_drgNdrpTxt2);

		// verify successfull drag and drop
		softassert.assertEquals(act_drgNdrpTxt1, exp_drgNdrpTxt1);
		softassert.assertEquals(act_drgNdrpTxt2, exp_drgNdrpTxt2);

		softassert.assertAll();
	}

}
