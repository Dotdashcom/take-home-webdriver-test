package TestLayer;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.Checkbox;



public class Checkbox_Test  extends BaseClass{
	
	Checkbox Che;
	public Checkbox_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		Che=new Checkbox();
	}
	@Test
	public void Checkbox_TC() throws InterruptedException {
		Thread.sleep(2000);
		Che.Checkbox1();
		Assert.assertTrue(Che.checkBox1.isSelected());
		Thread.sleep(2000);
		Che.Checkbox1();
		Assert.assertFalse(Che.checkBox1.isSelected());
		Thread.sleep(2000);
		Che.Checkbox2();
		Assert.assertFalse(Che.checkBox2.isSelected());
		Thread.sleep(2000);
		Che.Checkbox2();
		Assert.assertTrue(Che.checkBox2.isSelected());
		Thread.sleep(2000);
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	

}
