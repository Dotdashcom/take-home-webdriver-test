package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.Iframe;

public class Iframe_Test extends BaseClass {
	Iframe If;
	public  Iframe_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		If=new  Iframe();
		
	}
	@Test
	public void Iframe_TC() throws InterruptedException {
        Assert.assertEquals(If.getIframeText(), "Your content goes here.");
	}

	@AfterMethod
	public void close() {
	driver.close();
	}

}
