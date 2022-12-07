package com.dotdashcom.automation;

import org.testng.annotations.Test;
import com.dotdashcom.pom.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DotDashCom {
  PageActions obj;
  @BeforeClass
  public void beforeClass() {
	  obj = new PageActions();
  }
  @Test(priority=1)
  public void loginTestSuccess() {
	  obj.loginAction("tomsmith", "SuperSecretPassword!");
	  Assert.assertTrue(obj.checkLoginSuccess().contains("Secure"));
  }
  @Test(priority=2)
  public void loginTestFail() {
	  obj.loginAction("tomsmith", "wrong");
	  Assert.assertTrue(obj.checkLoginFail().contains("Your pass"));
  }
  @Test(priority=3)
  public void checkboxOnOff() {
	  obj.navigateCheckBox();
	  obj.checkBoxAction(0);
	  Assert.assertTrue(obj.getCheckboxStatus(0));
	  obj.checkBoxAction(1);
	  Assert.assertFalse(obj.getCheckboxStatus(1));
	  
	  obj.checkBoxAction(0);
	  Assert.assertFalse(obj.getCheckboxStatus(0));
	  obj.checkBoxAction(1);
	  Assert.assertTrue(obj.getCheckboxStatus(1));
  }
  @Test(priority=4)
  public void contextPopupTest() {
	  obj.navigateClickContextMenu();
	  String alertMessage = obj.validatePopupText();
	  Assert.assertTrue(alertMessage.contains("You selected a"));
  }
  @Test(priority=5)
  public void dragDropTest() {
	  obj.navigateDragDrop();
	  String[] texts = obj.getDragDropGetText();
	  obj.dragDrop();
	  String texts2[] = obj.getDragDropGetText();
	  Assert.assertEquals(texts, new String[] {"A","B"});
	  Assert.assertEquals(texts2, new String[] {"B","A"});
  }
  @Test(priority=6)
  public void dropdownTest() {
	  obj.navigateSelect();
	  String o1 = obj.selectOption("Option 1");
	  Assert.assertEquals(o1, "Option 1");
	  String o2 = obj.selectOption("Option 2");
	  Assert.assertEquals(o2, "Option 2");
  }
  @Test(priority = 7)
  public void dynamicContentTest() {
	  String s1 = obj.getDynamicText();
	  String s2 = obj.getDynamicText();
	  Assert.assertNotEquals(s1, s2);
  }
  @Test(priority=8)
  public void dynamic_controls_test() {
	  obj.navigateDynamicControl();
	  boolean checkBoxGone = obj.clickRemoveButton();
	  boolean checkBoxDis = obj.clickAddButton();
	  boolean textBoxEnable = obj.clickEnableButton();
	  boolean textBoxDisabled = obj.clickDisableButton();
	  Assert.assertTrue(checkBoxGone);
	  Assert.assertTrue(checkBoxDis);
	  Assert.assertTrue(textBoxEnable);
	  Assert.assertTrue(textBoxDisabled);
  }
  @Test(priority=9)
  public void dynamicLoadingTest() {
	  String text = obj.dynamicLoading();
	  Assert.assertTrue(text.contains("Hello World"));
  }
  @Test(priority=10)
  public void fileDownload() {
	  obj.fileDownload();
  }
  
  @Test(priority=11)
  public void floatingMenu() {
	  obj.navigateFloatingMenu();
	  Assert.assertTrue(obj.floatingMenu());
	  obj.scrollFloatingMenu();
	  Assert.assertTrue(obj.floatingMenu());
  }
  @Test(priority=12)
  public void iframeTest() {
	  String inp = "Im checking iframe";
	  String text = obj.checkIFrame(inp);
	 
	  Assert.assertEquals(text, inp);
  }
  @Test(priority=13)
  public void alertTest() {
	  String inp="Hello, im testing prompt";
	  obj.navigateAlert();
	  String jsAl = obj.clickJSAlert();
	  String jsConf = obj.clickJSConfirm();
	  String jsPr = obj.clickPrompt(inp);
	  Assert.assertEquals(jsAl,"I am a JS Alert");
	  Assert.assertEquals(jsConf,"I am a JS Confirm");
	  Assert.assertTrue(jsPr.contains(inp));
  }
  @Test(priority=14)
  public void jsError() {
	 
	  Assert.assertTrue(obj.jsError().toLowerCase().contains("javascript"));
  }
  @Test(priority=15)
  public void newWindowTest() {
	  String newWindowText = obj.checkNewTab();
	  Assert.assertEquals(newWindowText, "New Window");
  }
  
  @Test(priority=16)
  public void notificationTest() {
	  obj.navigateNotif();
	  Assert.assertTrue(obj.clickNotif());
  }
  @Test(priority=17)
  public void fileUpload(){
	  
	  obj.fileUpload();
	  String uploadedText = obj.getFileUploadText();
	  Assert.assertTrue(uploadedText.toLowerCase().contains("file uploaded"));
  }
  @AfterClass
  public void afterClass() {
	  obj.killBrowser();
  }

}
