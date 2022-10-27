package pageObjects;
import org.openqa.selenium.By;
import org.testng.Assert;

import utils.Baseclass;
public class jsAlertsPage 
{
	Baseclass bs;
	private final By button_clickOnJSAlert = By.xpath("//button[text()='Click for JS Alert']");
	private final By button_clickOnJSConfirm = By.xpath("//button[text()='Click for JS Confirm']");
	private final By button_clickOnJSPrompt = By.xpath("//button[text()='Click for JS Prompt']");
	private final By text_resultMessage = By.xpath("//p[@id='result']");
	public jsAlertsPage(Baseclass bs)
	{
		this.bs = bs;
	}
	
	public String getResultText()
	{
		return bs.getText(text_resultMessage);
	}
	
	public void clickOnJSAlert()
	{
		bs.click(button_clickOnJSAlert);
	}
	
	public void clickOnJSConfirm()
	{
		bs.click(button_clickOnJSConfirm);
	}
	
	public void clickOnJSPrompt()
	{
		bs.click(button_clickOnJSPrompt);
	}
}
