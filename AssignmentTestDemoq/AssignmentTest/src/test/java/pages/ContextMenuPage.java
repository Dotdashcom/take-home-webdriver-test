package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.WebHelper;

public class ContextMenuPage {
	

protected WebHelper helper;

	public ContextMenuPage(WebDriver driver , WebHelper helper) {		
		
		this.helper=helper;
	}
	
	
	public  By contextMenu = By.cssSelector("#hot-spot");
	
	public void rightClickContextMenu() {
		helper.contextClick(contextMenu);		
	}
	
	public String alertText() {
		return helper.GetalertText();
	}

	public void VerifyRightClick() {
		Assert.assertEquals(alertText(), "You selected a context menu");
		
	}
}
