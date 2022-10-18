package webtests.Testlayers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_002_Checkbox_POM;


public class WT_02_Checkbox_Test extends WT_BaseClass{
	
	WT_002_Checkbox_POM cb;
	
	//Constructor
	public WT_02_Checkbox_Test() {
		super();
	}

    @BeforeMethod
     public void initsetup() {
	
    cb= new WT_002_Checkbox_POM();

     driver.get(pr.getProperty("baseurl")+"/checkboxes");
     logg.info("****Checkboxurl opened****");
     
    }
    @Test (priority = 1)
    public void Checkbox1validation() throws InterruptedException {
	  
		  cb.checkbox1();
		  logg.info("****Test clicks on Checkbox 1****");
		  Thread.sleep(1000);
		  
		Assert.assertTrue(cb.ValidateCheckBox1());
		logg.info("****Test Passed****");
  }
   
    @Test (priority = 2)
    public void Checkbox2validation() throws InterruptedException {
	  
		  cb.checkbox2();
		  logg.info("****Test clicks on Checkbox 2****");
		  Thread.sleep(1000);
		   
		Assert.assertFalse(cb.ValidateCheckBox2());
		logg.info("****Test Passed****");
}   }
