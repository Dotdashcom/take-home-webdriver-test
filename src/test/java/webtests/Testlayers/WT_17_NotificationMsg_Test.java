package webtests.Testlayers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_017_NotificationMsg_POM;

public class WT_17_NotificationMsg_Test extends WT_BaseClass {

	WT_017_NotificationMsg_POM notification;
	
	//constructor
	public WT_17_NotificationMsg_Test(){
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
	
	notification = new WT_017_NotificationMsg_POM();
	
	driver.get(pr.getProperty("baseurl")+"/notification_message_rendered");
	logg.info("****NotificationMsg url opened****");
	
    }
	
	@Test(invocationCount = 4 )
	public void NotificationMessageTest()  {
	
		driver.navigate().refresh();
		
		notification.ClickHereLink();
		logg.info("****Test clicks on link****");
		
		 String text= notification.MessageBox();  
		
		if( text.contains("Action successful")){
			Assert.assertTrue(text.contains("Action successful"));
			logg.info("****Test Passed : Action successful ****");
			} 
		else if (text.contains("Action unsuccesful, please try again")) {
			 Assert.assertTrue(text.contains("Action unsuccesful, please try again"));
			 logg.info("****Test Passed : Action unsuccesful, please try again****");
			}
    	 else {
			 Assert.assertTrue(text.contains("Action Unsuccessful"));
			 logg.info("****Test Passed : Action unsuccesful****");
			
    	 }	
		
	}
	}
