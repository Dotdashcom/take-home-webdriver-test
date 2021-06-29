import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.IFrame;

public class IFrameTest {

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
	public void typeInEditor() {
		
		final String message = "Hello world, let us see if this editor works!";
		
		IFrame editor = new IFrame(driver);
		
		editor.clearEditor();
		editor.typeIntoEditor(message);
		
		String contents = editor.getEditorText();		
		assertTrue("Unexpected content in editor", contents.equals(message));

	}
		
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
