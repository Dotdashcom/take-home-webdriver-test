package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.JavaScriptErrorPage;

public class JavaScriptErrorTest extends TestBaseAssignment{
	
	@Test
	@Parameters({"JavaScriptErrorUrl"})
	public void JavaScriptErrorTestCase(String JavaScriptErrorUrl) throws InterruptedException{
		this.helper.getDriver().get(JavaScriptErrorUrl);
		this.helper.maximizeWindows();
		
		JavaScriptErrorPage dl = new JavaScriptErrorPage(helper );
		
		dl.VerifyJsError("Cannot read properties of undefined (reading 'xyz')");
		
		}

}
