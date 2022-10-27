package pageObjects;



import org.openqa.selenium.By;
import utils.Baseclass;

public class contextMenuPage 
{
	Baseclass bs;
	private final By hot_spot_area = By.xpath("//div[@id = 'hot-spot']");
	
	public contextMenuPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void rightClickonbox()
	{
		bs.contextClick(hot_spot_area);
	}
	
	
	
}
