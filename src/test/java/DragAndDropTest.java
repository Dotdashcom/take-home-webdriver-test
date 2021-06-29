import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.DragAndDrop;

public class DragAndDropTest {

	private WebDriver driver = null;
	
	@Before
	public void init() throws IOException {
		Browser browser = Browser.valueOf(
				PropertyReader.getPropertiesFromFile(
						"src/test/resources/config.properties",
						"browser"));
		
		driver = DriverFactory.getDriver(browser);
		driver.manage().window().maximize();		
	}
	
	@Test
	public void boxesLoadWithCorrectValues() {
		DragAndDrop dragAndDropPage = new DragAndDrop(driver);
		assertTrue("Wrong value detected", dragAndDropPage.getLeftBoxText().equals("A"));
		assertTrue("Wrong value detected", dragAndDropPage.getRightBoxText().equals("B"));
	}
	
	@Test
	public void dragLeftBoxOntoRightBox() {
		DragAndDrop dragAndDropPage = new DragAndDrop(driver);
		dragAndDropPage.dragLeftBoxOntoRight();
		assertTrue("Wrong value detected", dragAndDropPage.getLeftBoxText().equals("B"));
		assertTrue("Wrong value detected", dragAndDropPage.getRightBoxText().equals("A"));
	}
	
	@Test
	public void dragRightBoxOntoLeftBox() {
		DragAndDrop dragAndDropPage = new DragAndDrop(driver);
		dragAndDropPage.dragRightBoxOntoLeft();
		assertTrue("Wrong value detected", dragAndDropPage.getLeftBoxText().equals("B"));
		assertTrue("Wrong value detected", dragAndDropPage.getRightBoxText().equals("A"));
	}

	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
