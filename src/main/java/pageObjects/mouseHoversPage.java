package pageObjects;



import org.openqa.selenium.By;
import utils.Baseclass;

public class mouseHoversPage 
{
	Baseclass bs;
	private final By img_user1 = By.xpath("//div[@class='figure'][1]/img");
	private final By text_hover_user1 = By.xpath("//div[@class='figure'][1]/img/following-sibling::div/h5");
	private final By img_user2 = By.xpath("//div[@class='figure'][2]/img");
	private final By text_hover_user2 = By.xpath("//div[@class='figure'][2]/img/following-sibling::div/h5");
	private final By img_user3 = By.xpath("//div[@class='figure'][3]/img");
	private final By text_hover_user3 = By.xpath("//div[@class='figure'][3]/img/following-sibling::div/h5");
	
	public mouseHoversPage(Baseclass bs)	
	{
		this.bs = bs;
	}
	
	public void hoverOnUser1()
	{
		bs.mouseHover(img_user1);
	}
	
	public void hoverOnUser2()
	{
		bs.mouseHover(img_user2);
	}
	
	public void hoverOnUser3()
	{
		bs.mouseHover(img_user3);
	}
	
	public String getHoverTextUser1()
	{
		return bs.getText(text_hover_user1);
	}
	
	public String getHoverTextUser2()
	{
		return bs.getText(text_hover_user2);
	}
	
	public String getHoverTextUser3()
	{
		return bs.getText(text_hover_user3);
	}
	
	
}
