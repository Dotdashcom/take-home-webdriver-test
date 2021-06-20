import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DragAndDrop;

public class DragAndDropTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void boxesLoadWithCorrectValues() {
		DragAndDrop dragAndDropPage = new DragAndDrop(driver);
		assertTrue(dragAndDropPage.getLeftBoxText().equals("A"));
		assertTrue(dragAndDropPage.getRightBoxText().equals("B"));
	}
	
	@Test
	public void dragLeftBoxOntoRightBox() {
		DragAndDrop dragAndDropPage = new DragAndDrop(driver);
		dragAndDropPage.dragLeftBoxOntoRight();
		assertTrue(dragAndDropPage.getLeftBoxText().equals("B"));
		assertTrue(dragAndDropPage.getRightBoxText().equals("A"));
	}
	
	@Test
	public void dragRightBoxOntoLeftBox() {
		DragAndDrop dragAndDropPage = new DragAndDrop(driver);
		dragAndDropPage.dragRightBoxOntoLeft();
		assertTrue(dragAndDropPage.getLeftBoxText().equals("B"));
		assertTrue(dragAndDropPage.getRightBoxText().equals("A"));
	}

	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
