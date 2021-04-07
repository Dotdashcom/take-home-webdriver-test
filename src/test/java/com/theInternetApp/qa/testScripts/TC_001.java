package com.theInternetApp.qa.testScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.theInternetApp.qa.Utilities.BaseClass;
/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/

public class TC_001 extends BaseClass {

		//Login test with valid username and password
		@Test
		public void verify_Login_With_Valid_credentials() {
			theInternetApp().loginPage().getUrl();
			theInternetApp().loginPage().setUserName("tomsmith");
			theInternetApp().loginPage().setUserPasword("SuperSecretPassword!");
			theInternetApp().loginPage().clickLogIn();
			String loginSuccessText = theInternetApp().loginPage().getTextFlash();
			Assert.assertTrue(loginSuccessText.contains("You logged into a secure area!"));
	
		}
		
		
		//Login test with Invalid username and password
			@Test
		public void verify_Login_With_InValid_credentials() {
			theInternetApp().loginPage().getUrl();
			theInternetApp().loginPage().setUserName("InValid");
			theInternetApp().loginPage().setUserPasword("InValid");
			theInternetApp().loginPage().clickLogIn();
			String InValidloginText = theInternetApp().loginPage().getTextFlash();
			Assert.assertTrue(InValidloginText.contains("is invalid!"));

		}

		
	    //Test checks and unchecks checkboxes.
		@Test
		public void verify_Checked_And_Unchecked_Checkboxes() {
			theInternetApp().checkBoxesPage().getUrl();
			boolean unCheckedBox = theInternetApp().checkBoxesPage().UnCheckedBox();
			Assert.assertFalse(unCheckedBox);

			boolean CheckedBox = theInternetApp().checkBoxesPage().checkedBox();
			Assert.assertTrue(CheckedBox);
			
		}
		
		//Test Alert pop up upon right click on Box
		@Test
		public void verify_Alert_Is_Present_On_Right_Click() {
			theInternetApp().contextMenuPage().getUrl();
			boolean isAlertPresent = theInternetApp().contextMenuPage().rightClickOnBox();
			Assert.assertTrue(isAlertPresent);
		}
		
		//Test drag and drop from a to b
		@Test
		public void verify_Drag_And_Drop_From_BoxA_to_BoxB() {
			theInternetApp().dragAndDropPage().getUrl();
			theInternetApp().dragAndDropPage().dragAndDrop();
		}
		
		
		//Test dropdown
		@Test
		public void verifyDrop_Down() {
			theInternetApp().dropDownPage().getUrl();
			theInternetApp().dropDownPage().dropDown();
		}
		
		//Test Dynamic Content
		@Test
		public void verifyDynamicContent() {
			theInternetApp().dynamicContentPage().getUrl();
			theInternetApp().dynamicContentPage().verifyDynamicContent();
		}
		
		//Test Dynamic Controls
		@Test
		public void verifyDynamicControls() {
			theInternetApp().dynamicControlsPage().getUrl();
			theInternetApp().dynamicControlsPage().clickOnRemoveButton();
			String messege = theInternetApp().dynamicControlsPage().getMessageText();
			Assert.assertEquals("It's gone!", messege);
			
		}
		
		 //Test Dynamic Loading
		@Test
		public void verifyDynamicLoading() {
			theInternetApp().dynamicLoadingPage().getUrl();
			theInternetApp().dynamicLoadingPage().clickOnStartButton();
			String messege = theInternetApp().dynamicLoadingPage().getMessageText();
			Assert.assertEquals("Hello World!", messege);
			
		}
		
		//Test FileUpload
		@Test
		public void verifyFileUpload() {
			theInternetApp().fileUploadPage().getUrl();
			theInternetApp().fileUploadPage().uploadFile(System.getProperty("user.dir") + System.getProperty("file.separator") + "test.pdf");
			String messege = theInternetApp().fileUploadPage().getFileUploadedText();
			Assert.assertTrue(messege.contains("File Uploaded!"));
			
		}
		
		//Test Floating Menu
		@Test
		public void verifyFloatingMenu() {
			theInternetApp().floatingMenuPage().getUrl();
			theInternetApp().floatingMenuPage().getFloatingMenu();
			boolean displayOfMenu = theInternetApp().floatingMenuPage().isMenuDisplayed();
			Assert.assertTrue(displayOfMenu);
			
		}
		
		//Test Iframe
		@Test
		public void verifySwitchToFrame() {
			theInternetApp().iframePage().getUrl();
			theInternetApp().iframePage().getIframe();
			String content = theInternetApp().iframePage().getBodyContent();
			Assert.assertTrue(content.contains("Your content goes here."));
		}
		
		//Test Hovers on element
		@Test
		public void verifyHovers() {
			theInternetApp().hoversPage().getUrl();
			theInternetApp().hoversPage().getListOfUsers();
		}
}

		

