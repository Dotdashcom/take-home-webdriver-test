package take_home_webdriver_test.Webdriver_Tests;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import take_home_webdriver_test.Webdriver_Tests.pages.Checkboxes;
import take_home_webdriver_test.Webdriver_Tests.pages.ContextMenu;
import take_home_webdriver_test.Webdriver_Tests.pages.DragAndDrop;
import take_home_webdriver_test.Webdriver_Tests.pages.Dropdown;
import take_home_webdriver_test.Webdriver_Tests.pages.DynamicContent;
import take_home_webdriver_test.Webdriver_Tests.pages.DynamicControls;
import take_home_webdriver_test.Webdriver_Tests.pages.DynamicLoading;
import take_home_webdriver_test.Webdriver_Tests.pages.FileDownload;
import take_home_webdriver_test.Webdriver_Tests.pages.FileUpload;
import take_home_webdriver_test.Webdriver_Tests.pages.FloatingMenu;
import take_home_webdriver_test.Webdriver_Tests.pages.GenericMethods;
import take_home_webdriver_test.Webdriver_Tests.pages.IFrame;
import take_home_webdriver_test.Webdriver_Tests.pages.JavaScriptAlert;
import take_home_webdriver_test.Webdriver_Tests.pages.JavaScriptError;
import take_home_webdriver_test.Webdriver_Tests.pages.Login;
import take_home_webdriver_test.Webdriver_Tests.pages.MouseHover;
import take_home_webdriver_test.Webdriver_Tests.pages.NotificationMessage;
import take_home_webdriver_test.Webdriver_Tests.pages.OpenNewTab;

public class WebDriverTest{

  GenericMethods gnrcMthds;
  Login login;
  Checkboxes chkBx;
  ContextMenu cntxtMn;
  DragAndDrop drgDrp;
  Dropdown drpDwn;
  DynamicContent dynCnts;
  DynamicControls dynCntrls;
  DynamicLoading dynLd;
  FileDownload flDwnld;
  FileUpload flUpld;
  FloatingMenu fltngMnu;
  IFrame iFrm;
  JavaScriptAlert jvScrptAlrt;
  JavaScriptError jvScrptEr;
  MouseHover msHvr;
  NotificationMessage ntfctnMsg;
  OpenNewTab opnNwTb;
  WebDriver driver;
  
  @BeforeTest
  public void initTestSuite(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }
 
  @BeforeMethod
  public void initPageObjects() {
	 gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
	 login = PageFactory.initElements(driver, Login.class);
	 chkBx = PageFactory.initElements(driver, Checkboxes.class);
	 cntxtMn = PageFactory.initElements(driver, ContextMenu.class);
	 drgDrp = PageFactory.initElements(driver, DragAndDrop.class);
	 drpDwn = PageFactory.initElements(driver, Dropdown.class);
	 dynCnts = PageFactory.initElements(driver, DynamicContent.class);
	 dynCntrls = PageFactory.initElements(driver, DynamicControls.class);
	 dynLd = PageFactory.initElements(driver, DynamicLoading.class);
	 flDwnld = PageFactory.initElements(driver, FileDownload.class);
	 flUpld = PageFactory.initElements(driver, FileUpload.class);
	 fltngMnu = PageFactory.initElements(driver, FloatingMenu.class);
	 iFrm = PageFactory.initElements(driver, IFrame.class);
	 jvScrptAlrt = PageFactory.initElements(driver, JavaScriptAlert.class);
	 jvScrptEr = PageFactory.initElements(driver, JavaScriptError.class);
	 msHvr = PageFactory.initElements(driver, MouseHover.class);
	 ntfctnMsg = PageFactory.initElements(driver, NotificationMessage.class);
	 opnNwTb = PageFactory.initElements(driver, OpenNewTab.class);
  }

  @Test(enabled=false)
  public void verifyLoginPageHeading() {
    driver.get("http://localhost:7080/login");
    gnrcMthds.verifyPageHeading("Login Page");
  }
  
  @Test(enabled=false)
  public void verifyLogin() {
	  driver.get("http://localhost:7080/login");
	  String username="tomsmith";
	  String pswrd="SuperSecretPassword!";
      gnrcMthds.setValueInTextBox(login.username,username);
      gnrcMthds.setValueInTextBox(login.password,pswrd);
      gnrcMthds.clickOnElement(login.loginBtn);
      if (!(username.equals("tomsmith") && pswrd.equals("SuperSecretPassword!"))){
    	  gnrcMthds.verifyPageHeading("Login Page");
      }
      else {
    	  gnrcMthds.verifyPageHeading("Secure Area");
    	  gnrcMthds.verifyPageSubHeading("Welcome to the Secure Area. When you are done click logout below.");
      }
  }
  
  @Test(enabled=false)
  public void verifyCheckBoxes() {
	  driver.get("http://localhost:7080/checkboxes");
	  chkBx.VerifyThatCheckboxesWorksAsExpected();
  }	
  
  @Test(enabled=false)
  public void verifyContextMenu() {
	  driver.get("http://localhost:7080/context_menu");
	  cntxtMn.rightClickOnBox();
	  gnrcMthds.ifAlertPresentThenAssertTheText("You selected a context menu");
	  gnrcMthds.ifAlertPresentThenAccept();
  }
  
  @Test(enabled=false)
  public void verifyDragAndDrop() {
	  driver.get("http://localhost:7080/drag_and_drop");
	  String clmnA_bfrDrg=drgDrp.getColumnHeaderTxt(drgDrp.colmnABox);
	  String clmnB_bfrDrg=drgDrp.getColumnHeaderTxt(drgDrp.colmnBBox);
	  gnrcMthds.mouseActionDragAndDrop(drgDrp.colmnABox,drgDrp.colmnBBox);
	  String clmnA_aftrDrg=drgDrp.getColumnHeaderTxt(drgDrp.colmnABox);
	  String clmnB_aftrDrg=drgDrp.getColumnHeaderTxt(drgDrp.colmnBBox);
	  Assert.assertEquals(clmnA_aftrDrg, clmnB_bfrDrg);
	  Assert.assertEquals(clmnB_aftrDrg, clmnA_bfrDrg);
  }
  
  @Test(enabled=false)
  public void verifyDropDown() {
	  driver.get("http://localhost:7080/dropdown");
	  gnrcMthds.selectValueByVisibleTxtInDropDown(drpDwn.drpDwn, "Option 1");
	  Assert.assertEquals(true,gnrcMthds.ifValueIsSelectedInDropdown(drpDwn.drpDwn, "Option 1"));
	  gnrcMthds.selectValueByVisibleTxtInDropDown(drpDwn.drpDwn, "Option 2");
	  Assert.assertEquals(true,gnrcMthds.ifValueIsSelectedInDropdown(drpDwn.drpDwn, "Option 2"));
  }
  
  @Test(enabled=false)
  public void verifyDynamicContents() {
	  driver.get("http://localhost:7080/dynamic_content");
	  Assert.assertEquals(dynCnts.verifyTheContent(),true);
  }
  
  @Test
  public void verifyDynamicControls() {
	  driver.get("http://localhost:7080/dynamic_controls");
	  dynCntrls.clickOnRemoveButton();
	  gnrcMthds.waitForInvisibilityOfElemnt(dynCntrls.chckBox);
	  dynCntrls.clickOnAddButton();
	  gnrcMthds.waitFortheVisibilityOfElemnt(dynCntrls.chckBox);
	  dynCntrls.clickOnEnableButton();
	  gnrcMthds.waitFortheElementToBeClickable(dynCntrls.txtBox);
	  dynCntrls.clickOnDisableButton();
	  dynCntrls.verifyTxtBoxDisability();
  }
  
  @Test(enabled=false)
  public void verifyDynamicLoading() {
	  driver.get("http://localhost:7080/dynamic_loading/2");
	  dynLd.clickOnStartButton();
	  gnrcMthds.waitFortheVisibilityOfElemnt(dynLd.hloWrdTxt);
  }
  
  @Test(enabled=false)
  public void verifyFileDownload() {
	  driver.get("http://localhost:7080/download");
	  flDwnld.verifyIFFileExists();
	  flDwnld.clickOnFileNameLink();
	  try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  Assert.assertEquals(true, flDwnld.verifyIFFileExists());
  }
  
  @Test(enabled=false)
  public void verifyFileUpload() {
	  driver.get("http://localhost:7080/upload");
	  flUpld.sendFileTouploadAndClickOnUploadBtn();
	  flUpld.verifyUploadedFileName();
  }
  
  @Test(enabled=false)
  public void verifyFloatingMenu() {
	  driver.get("http://localhost:7080/checkboxes");
	  fltngMnu.scrollToTheBottom();
	  Assert.assertEquals(true, fltngMnu.verifyThatFloatingMenuIsdisplayed());
  }
  
  @Test(enabled=false)
  public void verifyIFrame() {
	  driver.get("http://localhost:7080/iframe");
	  chkBx.VerifyThatCheckboxesWorksAsExpected();
  }
  
  @Test(enabled=false)
  public void verifyJavaScriptAlert() {
	  driver.get("http://localhost:7080/javascript_alerts");
	  jvScrptAlrt.clickOnJsAlertButton();
	  gnrcMthds.ifAlertPresentThenAssertTheText("I am a JS Alert");
	  gnrcMthds.ifAlertPresentThenAccept();
	  jvScrptAlrt.clickOnJsCnfrmButton();
	  gnrcMthds.ifAlertPresentThenAssertTheText("I am a JS Confirm");
	  gnrcMthds.ifAlertPresentThenAccept();
	  jvScrptAlrt.clickOnJsPrmptButton();
	  gnrcMthds.ifAlertPresentThenEnterValInAlrtTxtBox("For Testing");
  }
  
  @Test(enabled=false)
  public void verifyJavaScriptError() {
	  driver.get("http://localhost:7080/javascript_error");
	  String jsError=((JavascriptExecutor) driver).executeScript("return window.javascript_errors ").toString();
  }
  
  @Test(enabled=false)
  public void verifyMouseHover() {
	  driver.get("http://localhost:7080/hovers");
	  Assert.assertEquals(true, msHvr.verifyTextDisplayedAfterMouseHover());
  }
  
  @Test(enabled=false)
  public void verifyNotificationMessage() {
	  driver.get("http://localhost:7080/notification_message_rendered");
	  opnNwTb.clickOnClikHereLink();
	  Assert.assertEquals("Action successful",ntfctnMsg.getTextOfFlashMessage());
	  opnNwTb.clickOnClikHereLink();
	  Assert.assertEquals("Action unsuccesful, please try again",ntfctnMsg.getTextOfFlashMessage());
	  opnNwTb.clickOnClikHereLink();
	  Assert.assertEquals("Action Unsuccessful",ntfctnMsg.getTextOfFlashMessage());
  }
  
  @Test(enabled=false)
  public void verifyNewTab() {
	  driver.get("http://localhost:7080/windows");
	  opnNwTb.clickOnClikHereLink();
	  Assert.assertEquals(true, opnNwTb.switchToWindowAndVerifyTxt());
  }
  
  @AfterTest()
  public void tearDown() {
    driver.quit();
  }
  
}
