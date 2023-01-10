package Dotdashcom.takehomewebdrivertest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class DynamicContent extends BaseClass {
	
	
	@FindBy(xpath="//a[contains(text(),'Dynamic Content')]")
	WebElement dynamiccontent;
	
	@FindBy(css="div[id=\"content\"] div[class=\"row\"]:first-child img")
	WebElement firstavatar;
	
	
	@FindBy(css="div[id=\\\"content\\\"] div[class=\\\"row\\\"]:first-child div[class*=large-10]")
	WebElement firsttext;
	
	

	Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	
	
	

	//Initializing the Page Objects:
	public DynamicContent(){
		PageFactory.initElements(driver, this);
	}

	
public  void clickondynamiccontent(){
		
		 j.executeScript("arguments[0].click();", new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dynamiccontent)));
		
				    	
			

}
	public  String getFirstAvatar(){
		String pagecontent = driver.getPageSource();
		System.out.println(pagecontent);
		return pagecontent;
				    	
			

}
	public  String getFirstRowText(){
		
		return firsttext.getText();
				    	
			

}
	public void refreshPage(){
        driver.navigate().refresh();
    }

}
