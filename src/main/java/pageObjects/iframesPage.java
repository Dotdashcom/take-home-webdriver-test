package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class iframesPage 
{
	Baseclass bs;
	private final By iframe = By.xpath("//iframe[@id = 'mce_0_ifr']");
	private final By textArea = By.xpath("//body[@id = 'tinymce']/p");
	public iframesPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void switchToFrame()
	{
		bs.switchToFrame(iframe);
	}
	
	public void setValuetoTextArea(String value)
	{
		bs.sendKeys(textArea, value);
	}
	
	public String getValueinTextArea()
	{
		return bs.getText(textArea);
	}
	
	
	
}
