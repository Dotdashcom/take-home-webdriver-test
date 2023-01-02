package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class Context_menu extends BaseClass {
	
	@FindBy(id = "hot-spot")
	public WebElement contextMenu;

	public Context_menu() {
		PageFactory.initElements(driver, this);
	}
	public void Con() {
		Actions action = new Actions(driver).contextClick(contextMenu);
		action.build().perform();
	}

}
