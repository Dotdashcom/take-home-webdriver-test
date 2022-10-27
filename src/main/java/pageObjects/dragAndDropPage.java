package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class dragAndDropPage 
{
	Baseclass bs;
	private final By elementA = By.xpath("//div[@class='column']/header[text()='A']");
	private final By elementB = By.xpath("//div[@class='column']/header[text()='B']");
	private final By columnA = By.xpath("//div[@id='column-a']");
	private final By columnB = By.xpath("//div[@id='column-b']");
	
	public dragAndDropPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void dragandDropcolumnAtoB()
	{
		bs.dragAndDrop(columnB, columnA);
	}
	
	
	public boolean verifyDragandDrop()
	{
		return bs.getText(columnB).equals("B");
	}
	
	
}
