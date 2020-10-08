package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class IframeTest extends TestBase{
	
	public IframeTest() throws IOException {
		super();	
	}
	
	@Test  
	public void verifyIframe()
	{
		driver.get(urlvalues.url_iframe);
		
		//handle the frames using SwitchTo() method 
		driver.switchTo().frame(data.iframe);	
		data.framebody.clear();
		data.framebody.sendKeys("hello everyone");
		String s1 = data.framebody.getText();
		String s2 = "hello everyone";
		Assert.assertEquals(s1, s2);
		System.out.println("text has been printed from IFrame");	
	}
}
