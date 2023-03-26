package org.ithaka.portico.demo.ui.base;

import java.util.concurrent.TimeUnit;

import org.ithaka.portico.demo.ui.pages.CheckBoxesPage;
import org.ithaka.portico.demo.ui.pages.ContextMenuPage;
import org.ithaka.portico.demo.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Base {

	public static void main(String[] args) {
		
		//Chrome driver
		
		//invoke .exe file
		//System.setProperty("webdriver.chrome.driver", "chromedriver 2");
			
		//Create driver object for chrome browser
		//Class name = ChromeDriver
		//ChromeDriver  driver = new ChromeDriver();
		
		WebDriverManager wdm = new WebDriverManager();
		WebDriver  driver = wdm.getDriver();
		
		//Go to the url
		//driver.get("http://localhost:7080/login");
		PageObjectManager pageObjectManager = new PageObjectManager(driver);
		LoginPage loginpage = pageObjectManager.getLoginPage();
		CheckBoxesPage checkboxesPage = pageObjectManager.getCheckboxesPage();
		ContextMenuPage contextMenuPage = pageObjectManager.getContextMenuPage();
		
		
		try {
			//loginpage.navigateToURL("http://localhost:7080/login");
			
			
			//loginpage.loginToAppSuccess("tomsmith", "SuperSecretPassword!");
			
			//loginpage.loginToAppFailure("tomsmith", "SuperSecretPassword");
	
			
			//checkboxesPage.checkTheBox();
			
			//contextMenuPage.rightClickTheContextMenu();
		
			
			//contextMenuPage.performDragDrop();

			//contextMenuPage.dropDownTest();
			
			//contextMenuPage.dynamicContent1();
			
			//contextMenuPage.dynamicContentWithExplicitWait();
			
			//contextMenuPage.dynamicContentWithExplicitWait2();
			
			//contextMenuPage.dynamicLoadingExercise2();
			
			//contextMenuPage.fileDownloader();
			
			//contextMenuPage.fileUploader();
			
			
			//contextMenuPage.scrollAndCheckMenu();
			
			//contextMenuPage.iframeExists();
			
			//contextMenuPage.hoversTest();
			
			//contextMenuPage.javascriptAlerts();
			
			//contextMenuPage.newWindow();
			
			contextMenuPage.notifications();
			
			Thread.sleep(4000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//loginpage.closeApp();

		//contextMenuPage.driver.quit();
		
		driver.quit();
	}

}