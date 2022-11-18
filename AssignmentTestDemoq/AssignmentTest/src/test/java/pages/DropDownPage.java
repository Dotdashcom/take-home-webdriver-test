package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;


public class DropDownPage {

	
	private WebHelper helper;
	
	public DropDownPage(WebDriver driver, WebHelper helper ) {		
		
		this.helper=helper;
	}
	
	By dropDown = By.cssSelector("#dropdown");
	
	public void slectOption1() {
		helper.selectFromDropDown(dropDown, "1");
	}
	
	public void slectOption2() {
		helper.selectFromDropDown(dropDown, "2");
	}
	
	public void VerifySelectedText(String text) {
		
		Assert.assertEquals(text, helper.getselectedText(dropDown));
		
	}
	
	
}
