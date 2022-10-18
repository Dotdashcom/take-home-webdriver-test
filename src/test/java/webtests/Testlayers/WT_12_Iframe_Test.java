package webtests.Testlayers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_012_Iframe_POM;

public class WT_12_Iframe_Test extends WT_BaseClass {

	WT_012_Iframe_POM frame;
	
	public WT_12_Iframe_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() { 
	
	frame = new WT_012_Iframe_POM();
	driver.get(pr.getProperty("baseurl")+"/iframe");
}
	
    @Test
    public void IFrameTest() {
    	frame.IFrame();
    	logg.info("****Switched to iframe****");

    	frame.WriteText();
    	Assert.assertEquals(frame.WriteText(), "Hello World");
    	logg.info("****Test Passed****");
    	
    	driver.switchTo().parentFrame();
    	logg.info("****Switched to parent frame****");
}}