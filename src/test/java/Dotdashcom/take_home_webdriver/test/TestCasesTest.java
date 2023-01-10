package Dotdashcom.take_home_webdriver.test;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

import Dotdashcom.takehomewebdrivertest.pages.Checkboxes;
import Dotdashcom.takehomewebdrivertest.pages.ContextMenu;
import Dotdashcom.takehomewebdrivertest.pages.DragAndDrop;
import Dotdashcom.takehomewebdrivertest.pages.DropDown;
import Dotdashcom.takehomewebdrivertest.pages.DynamicContent;
import Dotdashcom.takehomewebdrivertest.pages.DynamicControls;
import Dotdashcom.takehomewebdrivertest.pages.DynamicLoading;
import Dotdashcom.takehomewebdrivertest.pages.FileDownload;
import Dotdashcom.takehomewebdrivertest.pages.FileUpload;
import Dotdashcom.takehomewebdrivertest.pages.FloatingMenu;
import Dotdashcom.takehomewebdrivertest.pages.IFrame;
import Dotdashcom.takehomewebdrivertest.pages.MouseHover;
import Dotdashcom.takehomewebdrivertest.pages.JavaScriptsAlert;
import Dotdashcom.takehomewebdrivertest.pages.JavaScriptError;
import Dotdashcom.takehomewebdrivertest.pages.NewTab;
import Dotdashcom.takehomewebdrivertest.pages.NotificationMessage;


public class TestCasesTest extends BaseClass {
	Checkboxes checkboxes;
	ContextMenu contextmenu;
	DragAndDrop draganddrop;
	DropDown dropdown;
	DynamicContent dynamiccontent;
	DynamicControls dynamiccontrols;
	DynamicLoading dynamicloading;
	FileDownload  filedownload;
	FileUpload fileupload;
	FloatingMenu floatingmenu;
	IFrame iframe;
	MouseHover mousehover;
	JavaScriptsAlert javascriptsalert;
	JavaScriptError javascripterror;
	NewTab newtab;
	NotificationMessage notificationmessage;
	
	
    

public TestCasesTest(){
	super();
}

@BeforeMethod
public void setUp(){
	initialization();
	driver.get(prop.getProperty("url1"));
	checkboxes = new Checkboxes();
	contextmenu = new ContextMenu();
	draganddrop = new DragAndDrop();
	dropdown= new DropDown();
	dynamiccontent  = new DynamicContent();
	dynamiccontrols  = new DynamicControls();
	dynamicloading = new DynamicLoading();
	filedownload = new FileDownload();
	fileupload  = new FileUpload ();
	floatingmenu = new FloatingMenu ();
	iframe  = new IFrame ();
	mousehover = new MouseHover();
	javascriptsalert = new JavaScriptsAlert ();	
	javascripterror = new JavaScriptError ();	
	newtab = new NewTab ();
	notificationmessage = new NotificationMessage ();

	
}
@Test(priority=1)
public void checkbox1statusTest() throws InterruptedException{		
	
	boolean ToastMessage = checkboxes.checkbox1status();
	Assert.assertTrue(ToastMessage);
		
	
	
} 

@Test(priority=2)
public void contextmenuTest() throws InterruptedException{		
	
	String Text1 = contextmenu.contextmenu();
	Assert.assertEquals(Text1, "You selected a context menu");
		
	
	
} 


@Test(priority=3)
public void draganddropTest() throws InterruptedException{		
	
	 draganddrop.draganddrop();
     Thread.sleep(1000);
     Assert.assertEquals("A",draganddrop.getTextBoxA());
 }
		
	
	
 
@Test(priority=4)
public void DropDownOption1Test() throws InterruptedException{		
	
	String Text1 = dropdown.draganddropoption1();
    Assert.assertEquals(Text1, "Option 1");
		
	
	
}

@Test(priority=5)
public void DropDownOption2Test() throws InterruptedException{		
	
	String Text1 = dropdown.draganddropoption2();
    Assert.assertEquals(Text1, "Option 2");
		
	
	
}

@Test(priority=6)
public void DyamicContent() throws InterruptedException{	
	dynamiccontent.clickondynamiccontent();
	 String beforerefreshcontent = dynamiccontent.getFirstAvatar();
	 dynamiccontent.refreshPage();
	 String afterrefreshcontent = dynamiccontent.getFirstAvatar();
	
    
    Assert.assertNotEquals(beforerefreshcontent, afterrefreshcontent);
		
	
	
}
@Test(priority=7)
public void DyamicControls() throws InterruptedException{	
	dynamiccontrols.clickondynamiccontrols();
	dynamiccontrols.clickRemoveButton();
    Assert.assertEquals(dynamiccontrols.getMessage(driver),"It's gone!");
    dynamiccontrols.clickAddButton();
    Assert.assertEquals(dynamiccontrols.getMessage(driver),"It's back!");
    dynamiccontrols.clickEnableButton();
    Assert.assertEquals(dynamiccontrols.getMessage(driver),"It's enabled!");
    dynamiccontrols.clickDisableButton();
    Assert.assertEquals(dynamiccontrols.getMessage(driver),"It's disabled!");
	
}

@Test(priority=8)
public void DynamicLoading() throws InterruptedException{	
	dynamicloading.clickondynamicloading();
	dynamicloading.clickButtons();
    Assert.assertEquals(dynamicloading.getMessage(driver),"Hello World!");
	
}
@Test(priority=9)
public void FileDownload() throws InterruptedException{	
	filedownload.clickonfiledownload();
	filedownload.downloadButton();
	Assert.assertTrue(filedownload.fileexist("C:\\Users\\hp-pc\\Downloads\\some-file.txt"));

	
}

@Test(priority=10)
public void FileUpload() throws InterruptedException{	
	fileupload.clickFileUpload();
	fileupload.clickChooseButton("C:\\Users\\hp-pc\\Downloads\\some-file.txt");
	fileupload.clickUploadButton();
       Assert.assertEquals(fileupload.getText(),"File Uploaded!");

	
}

@Test(priority=10)
public void FloatingMenu() throws InterruptedException{	
	
	floatingmenu.clickFloatingMenu();
	floatingmenu.clickScrollButton(driver);
    Assert.assertTrue(floatingmenu.isDisplayedHome());
}


@Test(priority=10)
public void IFrame() throws InterruptedException{	
	
	iframe.clickButtons();
	iframe.sendAndGetText(driver);
//	iframe.notificationMsg(driver);
Assert.assertEquals(iframe.sendAndGetText(driver),"my input message");
}

@Test(priority=11)
public void MouseHover() throws InterruptedException{	
	
	Assert.assertTrue(mousehover.mousehover());
}

@Test(priority=12)
public void JavaScriptsAlert() throws InterruptedException{	
	
	        
	javascriptsalert.clickJavaScriptAlerts();
	javascriptsalert.validateJsAlertMsg(driver);

	    }

@Test(priority=13)
public void JavaScriptsConfirmTest() throws InterruptedException{	
	
	        
	javascriptsalert.clickJavaScriptAlerts();
	javascriptsalert.validateJsConfirmMsg(driver);

	    }
	  
@Test(priority=14)
public void JavaScriptsConfirmMsg() throws InterruptedException{	
	
	        
	javascriptsalert.clickJavaScriptAlerts();
	javascriptsalert.validateJsPrompt(driver);

	    }

@Test(priority=15)
public void JavaScriptsError() throws InterruptedException{	
	
	        
	javascripterror.clickJavaScriptError();
	javascripterror.verifyError();

	    }
	   
@Test(priority=16)
public void NewTab() throws InterruptedException{	
	
	        
	newtab.clickButtons();
	Assert.assertEquals(newtab.validateNewHeader(),"Opening a new window");

	    }
@Test(priority=17)
public void NotificationMessage() throws InterruptedException{	
	
	        
	notificationmessage.clickButton();
	notificationmessage.clickHere();
      List<String> messages=new ArrayList<>();
      String message1="Action successful";
      String message2="Action unsuccessful";
      String message3="Action unsuccessful, please try again";
      messages.add(message1);
      messages.add(message2);
      messages.add(message3);

      for(int i=0;i<10;i++){
    	  notificationmessage.clickHere();
          for (int j=0;j< messages.size();j++){
              if(messages.get(j).equals(notificationmessage.validateMessage())){
                  Assert.assertEquals(messages.get(j),notificationmessage.validateMessage());
                  break;
              }
          }
      }


  }

	    


@AfterMethod	

public void tearDown(){
	driver.quit();
}


}