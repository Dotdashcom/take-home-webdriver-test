package org.ithaka.portico.demo.ui.pages;

import org.ithaka.portico.demo.ui.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public  WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage() {}
	
	@FindBy(id="username")
	public WebElement userName_tbox;
	
	@FindBy(id="password")
	public WebElement pwd_tbox;
	
	@FindBy(className="fa-sign-in")
	public WebElement login_btn;
	
	@FindBy(className="icon-signout")
	public WebElement logout_btn;
	
	@FindBy(className="flash")
	public WebElement invalidPassword;
	
	public void navigateToURL(String urlEnv) throws Exception {
	
		//Go to the url
		driver.get("http://localhost:7080/login");	
			
		// Maximize window size of browser
	    driver.manage().window().maximize();
	    
	}
	
	public void loginToAppSuccess(String userName, String password) {
	        
		userName_tbox.sendKeys(userName);
		pwd_tbox.sendKeys(password);
		
		
		login_btn.click();
		logout_btn.click();
	
	}
	
	public void loginToAppFailure(String userName, String password) {
        
		userName_tbox.sendKeys(userName);
		pwd_tbox.sendKeys(password);
		
		
		login_btn.click();
		Assert.assertNotNull(invalidPassword);
	
	}
	
	public void closeApp() {
		this.driver.close();
		this.driver = null;
	}
	
}
