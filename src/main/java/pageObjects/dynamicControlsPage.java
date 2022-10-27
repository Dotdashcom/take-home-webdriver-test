package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class dynamicControlsPage 
{
	Baseclass bs;
	private final By button_Remove = By.xpath("//button[text()='Remove']");
	private final By button_Add = By.xpath("//button[text()='Add']");
	private final By button_Enable = By.xpath("//button[text()='Enable']");
	private final By button_Disable = By.xpath("//button[text()='Disable']");
	private final By checkbox = By.xpath("//input[@id='checkbox']");
	private final By textbox = By.xpath("//input[@type='text']");
	private final By textbox_disabled = By.xpath("//input[@type='text' and @disabled='']");
	public dynamicControlsPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void clickOnEnableButton()
	{
		bs.click(button_Enable);
		bs.waitUntilElementInvisibility(textbox_disabled);
	}
	
	public void clickOnDisableButton()
	{
		bs.click(button_Disable);
		bs.checkElementExists(textbox_disabled);
	}
	
	public void clickOnAddButton()
	{
		bs.click(button_Add);
		
	}
	
	public void clickOnRemoveButton()
	{
		bs.click(button_Remove);
		bs.waitUntilElementInvisibility(checkbox);
	}
	
	public boolean verifyCheckBoxExists()
	{
		return bs.checkElementExists(checkbox,20);
	}
	
	public boolean verifyTextBoxEnabled()
	{
		return bs.checkElementEnabled(textbox);
	}
}
