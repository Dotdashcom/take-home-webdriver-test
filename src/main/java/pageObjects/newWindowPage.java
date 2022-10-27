package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class newWindowPage 
{
	Baseclass bs;
	private final By button_ClickHere = By.xpath("//a[text()='Click Here']");
	private final By text_NewWindow = By.xpath("//h3[text()='New Window']");
	
	public newWindowPage(Baseclass bs)
	{
		this.bs = bs;
	}
	
	public void clickOnClickHere()
	{
			bs.click(button_ClickHere);
	}
	
	public boolean verifyHeaderTextFromNewWindow()
	{
			bs.switchToNextWindow();
			return bs.checkElementExists(text_NewWindow);
	}
}
