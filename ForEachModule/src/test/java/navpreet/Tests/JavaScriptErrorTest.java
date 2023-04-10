package navpreet.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import navpreet.pageobjects.JavaScriptErrorPageObjects;
import navpreet.util.ObjectsOfClasses;

public class JavaScriptErrorTest extends ObjectsOfClasses {

	ObjectsOfClasses base_instance;
	JavaScriptErrorPageObjects jepo;
	
	@Test(description="Test finds the JavaScript error on the page.Test asserts that the page contains error: Cannot read property 'xyz' of undefined.")
	public void TestJavaScriptError() throws IOException
	{
		jepo=javaScriptErrorApplication();
		jepo.ClickJavaScriptError();
		String jsError=jepo.checkJSError();
		Assert.assertEquals(jsError, "http://localhost:7080/javascript_error 6:51 Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')");
	}
}
