package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class dynamicLoadingPage 
{
	Baseclass bs;
	private final By link_ElementHiddenOnPage = By.xpath("//a[@href='/dynamic_loading/1']");
	private final By link_ElementRenderedAfterFact = By.xpath("//a[@href='/dynamic_loading/2']");
	private final By button_Start = By.xpath("//button[text()='Start']");
	private final By finish_Text = By.xpath("//div[@id='finish']");
	
	public dynamicLoadingPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void clickOnElementHiddenOnPage()
	{
		bs.click(link_ElementHiddenOnPage);
	}
	
	public void clickOnElementRenderedAfterFact()
	{
		bs.click(link_ElementRenderedAfterFact);
	}
	
	public void clickOnStartButton()
	{
		bs.click(button_Start);
	}
	
	public String getTextAfterStart()
	{
		return bs.getText(finish_Text);
	}
	
	
	
	
	
}
