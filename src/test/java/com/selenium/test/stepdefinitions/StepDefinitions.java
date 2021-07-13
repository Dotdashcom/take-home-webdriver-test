	package com.selenium.test.stepdefinitions;
	
	import com.selenium.entity.DataSingleton;
	import cucumber.api.java.en.Then;
	
	public class StepDefinitions {
	
		final static DataSingleton singleton = DataSingleton.getInstance();
	
		@Then("^I Test \"([^\"]*)\"$")
		public void ITest(String test) {
	
			System.out.println("USER : " + test);
		}
	
		@Then("^I navigate to url \"([^\"]*)\"$")
		public void Open_Url(String url) {
	
			StepMethod.loginSuccess(url);
	
		}
	
		@Then("^I enter username as \"([^\"]*)\"$")
		public void EnterUser(String user) {
	
			StepMethod.EnterUser(user);
	
		}
	
		@Then("^I enter password as \"([^\"]*)\"$")
		public void EnterPassword(String password) {
	
			StepMethod.EnterPassword(password);
	
		}
	
		@Then("^I verify file downloaded$")
		public void FileDownlaod() {
	
			StepMethod.FileDownlaod();
	
		}
	
		@Then("^I verify notification message$")
		public void NotificationMessage() {
	
			StepMethod.NotificationMessage();
	
		}
	
		@Then("^I open in new window and verify$")
		public void NewWindow() {
	
			try {
				StepMethod.NewWindow();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
	
		@Then("^I test javascript alert$")
		public void JavaScriptAlert() {
	
			StepMethod.JavaScriptAlert();
	
		}
	
		@Then("^I test javascript error$")
		public void JavaScriptError() {
	
			try {
				StepMethod.JavaScriptError();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
	
		@Then("^I test mouse hover and validate additional info$")
		public void MouseHover() {
	
			try {
	
				StepMethod.MouseHover();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
	
		@Then("^I verify file uploaded$")
		public void FileUpload() {
	
			StepMethod.FileUpload();
	
		}
	
		@Then("I check IFrame and validate text$")
		public void IFrame() {
	
			StepMethod.IFrame();
	
		}
	
		@Then("^I click Login$")
		public void EnterPassword() {
	
			StepMethod.ClickLogin();
	
		}
	
		@Then("^I verify dynamic control$")
		public void DynamicControl() {
	
			StepMethod.DynamicControl();
	
		}
	
		@Then("^I verify dynamic loading$")
		public void DynamicLoading() {
	
			StepMethod.DynamicLoading();
	
		}
	
		@Then("^I verify content changes on each refresh$")
		public void ContentChange() {
	
			StepMethod.ContentChange();
	
		}
	
		@Then("^I should be logged into the system$")
		public void SuccessLogin() {
	
			StepMethod.ValidateLogin();
	
		}
	
		@Then("^I check both boxes and verify$")
		public void CheckBox() {
	
			StepMethod.CheckBox();
	
		}
	
		@Then("^I check drag and drop and verify$")
		public void DragAndDrop() {
	
			try {
	
				StepMethod.DragAndDrop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
	
		@Then("^I verify dropdown$")
		public void DropDown() {
	
			StepMethod.DropDown();
	
		}
	
		@Then("^I right click and verify the alert$")
		public void ContextMenu() {
	
			StepMethod.ContextMenu();
	
		}
	
		@Then("^I check floating menu$")
		public void FloatingMenu() {
	
			StepMethod.FloatingMenu();
	
		}
	
		@Then("^I should not be logged into the system and system should popup message \\\"([^\\\"]*)\\\"$")
		public void FailedLogin(String message) {
	
			StepMethod.FailedLogin(message);
	
		}
	
	}
