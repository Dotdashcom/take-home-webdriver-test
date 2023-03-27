package org.ithaka.portico.demo.ui.base;

import org.ithaka.portico.demo.ui.pages.CheckBoxesPage;
import org.ithaka.portico.demo.ui.pages.ContextMenuPage;
import org.ithaka.portico.demo.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private CheckBoxesPage checkboxesPage;
	private ContextMenuPage contextMenuPage;
	
	
	public PageObjectManager(WebDriver driver) {
		 
		this.driver = driver;
	}
 
	public LoginPage getLoginPage() {
		 
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	public CheckBoxesPage getCheckboxesPage() {
		return (checkboxesPage == null) ? checkboxesPage = new CheckBoxesPage(driver) : checkboxesPage;
 
	}
	
	public ContextMenuPage getContextMenuPage() {

		return (contextMenuPage == null) ? contextMenuPage = new ContextMenuPage(driver) : contextMenuPage;
 
	}

}
