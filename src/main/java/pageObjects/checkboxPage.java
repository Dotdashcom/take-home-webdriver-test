package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class checkboxPage 
{
	Baseclass bs;
	private final By checkbox1_Locator = By.xpath("//form[@id='checkboxes']/input[1]");
	private final By checkbox2_Locator = By.xpath("//form[@id='checkboxes']/input[2]");
	public checkboxPage(Baseclass bs)
	{
		this.bs = bs;
	}
	
	public void updateCheckbox1(boolean status)
	{
		if(bs.verifyCheckboxIsSelected(checkbox1_Locator) && status)
			System.out.println("checkbox is already set to "+ status);
		else
			bs.click(checkbox1_Locator);
	}
	
	public void updateCheckbox2(boolean status)
	{
		if(bs.verifyCheckboxIsSelected(checkbox2_Locator) && status)
			System.out.println("checkbox is already set to "+ status);
		else
			bs.click(checkbox2_Locator);
	}
	
	public boolean verifycheckbox1Status()
	{
		return bs.verifyCheckboxIsSelected(checkbox1_Locator); 
	}
	
	public boolean verifycheckbox2Status()
	{
		return bs.verifyCheckboxIsSelected(checkbox2_Locator);
	}
	
}
