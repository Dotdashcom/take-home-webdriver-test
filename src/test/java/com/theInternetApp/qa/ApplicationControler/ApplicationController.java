package com.theInternetApp.qa.ApplicationControler;

import org.openqa.selenium.WebDriver;

import com.theInternetApp.qa.pageObjects.CheckBoxesPage;
import com.theInternetApp.qa.pageObjects.ContextMenuPage;
import com.theInternetApp.qa.pageObjects.DragAndDropPage;
import com.theInternetApp.qa.pageObjects.DropDownPage;
import com.theInternetApp.qa.pageObjects.DynamicContentPage;
import com.theInternetApp.qa.pageObjects.DynamicControlsPage;
import com.theInternetApp.qa.pageObjects.DynamicLoadingPage;
import com.theInternetApp.qa.pageObjects.FileUploadPage;
import com.theInternetApp.qa.pageObjects.FloatingMenuPage;
import com.theInternetApp.qa.pageObjects.HoversPage;
import com.theInternetApp.qa.pageObjects.IframePage;
import com.theInternetApp.qa.pageObjects.LoginPage;
/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class ApplicationController{

	protected WebDriver driver = null;
	private LoginPage loginPage = null;
	private CheckBoxesPage checkBoxesPage = null;
	private ContextMenuPage contextMenuPage = null;
	private DragAndDropPage dragAndDropPage = null;
	private DropDownPage dropDownPage = null;
	private DynamicContentPage dynamicContentPage = null;
	private DynamicControlsPage dynamicControlsPage = null;
	private DynamicLoadingPage dynamicLoadingPage = null;
	private FileUploadPage fileUploadPage = null;
	private FloatingMenuPage floatingMenuPage = null;
	private IframePage iframePage = null;
	private HoversPage hoversPage = null;


	
	public ApplicationController(WebDriver driver) {
		this.driver = driver;
	}

	//Login Page
	public LoginPage loginPage(){
        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

	//CheckBoxes Page
	public CheckBoxesPage checkBoxesPage() {
		if(checkBoxesPage == null){
			checkBoxesPage = new CheckBoxesPage(driver);
        }
        return checkBoxesPage;
	}
	
	//Context Menu Page
		public ContextMenuPage contextMenuPage() {
			if(contextMenuPage == null){
				contextMenuPage = new ContextMenuPage(driver);
	        }
	        return contextMenuPage;
		}
		//Drag And Drop Page
	
		public DragAndDropPage dragAndDropPage() {
			if(dragAndDropPage == null){
				dragAndDropPage = new DragAndDropPage(driver);
	        }
	        return dragAndDropPage;
		}
	
		//Drop Down Page Page
		public DropDownPage dropDownPage() {
			if(dropDownPage == null){
				dropDownPage = new DropDownPage(driver);
	        }
	        return dropDownPage;
		}
			
		//dynamic Content Page
		public DynamicContentPage dynamicContentPage() {
			if(dynamicContentPage == null){
				dynamicContentPage = new DynamicContentPage(driver);
	        }
	        return dynamicContentPage;
		}
		
		//dynamic Controls Page
		public DynamicControlsPage dynamicControlsPage() {
			if(dynamicControlsPage == null){
				dynamicControlsPage = new DynamicControlsPage(driver);
	        }
	        return dynamicControlsPage;
		}
		
		// Dynamic Loading Page
		public DynamicLoadingPage dynamicLoadingPage() {
			if (dynamicLoadingPage == null) {
				dynamicLoadingPage = new DynamicLoadingPage(driver);
			}
			return dynamicLoadingPage;
		}
	
		// file Upload Page
		public FileUploadPage fileUploadPage() {
			if (fileUploadPage == null) {
				fileUploadPage = new FileUploadPage(driver);
			}
			return fileUploadPage;
		}
		
		// Floating Menu Page
		public FloatingMenuPage floatingMenuPage() {
			if (floatingMenuPage == null) {
				floatingMenuPage = new FloatingMenuPage(driver);
			}
			return floatingMenuPage;
		}
		
		// Iframe Page
		public IframePage iframePage() {
			if (iframePage == null) {
				iframePage = new IframePage(driver);
			}
			return iframePage;
		}
		// Hovers Page
		public HoversPage hoversPage() {
			if (hoversPage == null) {
				hoversPage = new HoversPage(driver);
			}
			return hoversPage;
		}
}
