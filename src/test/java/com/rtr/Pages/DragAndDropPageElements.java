package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class DragAndDropPageElements extends CommonMethods{
	

	@FindBy (id = "column-a")
	public WebElement boxa;
	
	@FindBy (id = "column-b")
	public WebElement boxb;
	
	@FindBy (xpath = "//div[@id='column-a']/header")
	public WebElement firstletter;
	
	@FindBy (xpath = "//div[@id='column-b']/header")
	public WebElement secondletter;
	
	
	public DragAndDropPageElements() {
		PageFactory.initElements(driver, this);
	}

}
