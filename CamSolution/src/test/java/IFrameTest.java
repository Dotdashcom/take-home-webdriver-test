import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.IFrame;

public class IFrameTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void typeInEditor() {
		
		final String message = "Hello world, let us see if this editor works!";
		
		IFrame editor = new IFrame(driver);
		
		editor.clearEditor();
		editor.typeIntoEditor(message);
		
		String contents = editor.getEditorText();		
		assertTrue(contents.equals(message));

	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
