package webtests.Testlayers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_004_DragandDrop_POM;

public class WT_04_DragandDrop_Test extends WT_BaseClass {
	
	WT_004_DragandDrop_POM dd;
	
	//Constructor
	public WT_04_DragandDrop_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		
		dd= new WT_004_DragandDrop_POM();
		
	 driver.get(pr.getProperty("baseurl")+"/drag_and_drop");
	  logg.info("****DragAndDrop url opened****");
	
    }

	@Test
	public void DragAndDropA() throws IOException  {
		
		dd.dragAndDrop();
		
	 String t = dd.TextA().getText();
		if(t.equals("A")) {
			Assert.assertTrue(true);
			logg.info("****Test Passed****");
		}
		else {
			Assert.assertTrue(false);
			logg.info("****Test Failed****");
			captureScreen(driver, "Drag&Drop");
		}
		
		
	}
	
	
	
}
