package com.testing;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFile {
	
	PageFile pf = new PageFile();
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		pf.openBrowser();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("\n\n" + "TEST NAME: " + result.getMethod().getMethodName() + "\n\n");
		pf.closeBrowser();
	}
	
    @Test (priority=1)
    public void loginWithValidCredentialsTest() throws Exception
    {
    	pf.loginWithValidCredentials();
    }
   
    @Test (priority=2)
    public void loginWithInValidCredentialsTest() throws Exception
    {
    	pf.loginWithInValidCredentials();
    }
 
    @Test (priority=3)
    public void checkboxTest() throws Exception
    {
    	pf.checkbox();
    }
   
    @Test (priority=4)
    public void contextMenuTest() throws Exception
    {
    	pf.contextMenu();
    }
 
    @Test (priority=5)
    public void dragAndDropTest() throws Exception
    {
    	pf.dragDrop();
    }
  
    @Test (priority=6)
    public void dropdownTest() throws Exception
    {
    	pf.dropdown();
    }
   
    @Test (priority=7)
    public void dynamicContentTest() throws Exception
    {
    	pf.dynamicContent();
    }
  
    @Test (priority=8)
    public void dynamicControlsTest() throws Exception
    {
    	pf.dynamicControls();
    }
      
    @Test (priority=9)
    public void dynamicLoadingTest() throws Exception
    {
    	pf.dynamicLoading();
    }
       
    @Test (priority=10)
    public void fileDownloadTest() throws Exception
    {
    	pf.fileDownload();
    }

	@Test (priority=11)
	public void fileUploadTest() throws Exception
	{
    	pf.fileUpload();
    }
	   
    @Test (priority=12)
    public void floatingMenuTest() throws Exception
    {
    	pf.floatingMenu();
    }
   
    @Test (priority=13)
    public void iFrameTest() throws Exception
    {
    	pf.iFrame();
    }
  
    @Test (priority=14)
    public void mouseHoverTest() throws Exception
    {
    	pf.mouseHover();
    }
  
    @Test (priority=15)
    public void javaScriptAlertTest() throws Exception
    {
    	pf.javaScriptAlert();
    }
  
    @Test (priority=16)
    public void javaScriptErrorTest() throws Exception
    {
    	pf.javaScriptError();
    }
  
    @Test (priority=17)
    public void newTabTest() throws Exception
    {
    	pf.newTab();
    }
  
    @Test (priority=18)
    public void messageNotificationTest() throws Exception
    {
    	pf.messageNotification();
    }
   
}
