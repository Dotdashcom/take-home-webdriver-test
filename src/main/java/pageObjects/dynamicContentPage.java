package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class dynamicContentPage 
{
	Baseclass bs;
	private final By link_clickHere = By.xpath("//a[text() = 'click here']");
	private final By TextArea1 = By.xpath("//div[@id = 'content']/div[@class='row'][1]/div[@class='large-10 columns']");
	private final By TextArea2 = By.xpath("//div[@id = 'content']/div[@class='row'][2]/div[@class='large-10 columns']");
	private final By TextArea3 = By.xpath("//div[@id = 'content']/div[@class='row'][3]/div[@class='large-10 columns']");
	
	public dynamicContentPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void clickOnClickHereLink()
	{
		bs.click(link_clickHere);
	}
	
	public String getTextinArea1()
	{
		return bs.getText(TextArea1);
	}
	
	public String getTextinArea2()
	{
		return bs.getText(TextArea2);
	}
	
	public String getTextinArea3()
	{
		return bs.getText(TextArea3);
	}
	
	
	
}
