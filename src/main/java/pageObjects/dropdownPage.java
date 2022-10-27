package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class dropdownPage 
{
	Baseclass bs;
	private final By dropdown_List = By.xpath("//select[@id = 'dropdown']");
	
	public dropdownPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void selectValueinList(String value)
	{
		bs.selectValueinLOV(dropdown_List, value);
	}
	
	public String getSelectedValueinList()
	{
		return bs.getSelectedValueLOV(dropdown_List);
	}
	
	
	
}
