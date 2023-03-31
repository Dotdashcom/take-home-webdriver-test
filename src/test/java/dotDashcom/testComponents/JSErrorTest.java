package dotDashcom.testComponents;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import dotDashcom.pageObjects.JSErrorPage;


public class JSErrorTest extends BaseTest{
	
	JSErrorPage error;
	@Before
	public void setup() throws IOException {

		setup("/javascript_error");
		error= new JSErrorPage(driver);
	}
	
	@Test
	public void getJSError() {
		String jsError=error.checkJSError();
		Assert.assertThat(jsError, containsString("TypeError: Cannot read properties of undefined (reading 'xyz')"));
	}
	
}
