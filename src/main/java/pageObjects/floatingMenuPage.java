package pageObjects;

import org.openqa.selenium.By;
import utils.Baseclass;

public class floatingMenuPage 
{
	Baseclass bs;
	private final By footerLink	 = By.xpath("//a[text()='Elemental Selenium']");
	private final By button_Home = By.xpath("//a[text()='Home']");
	private final By button_News = By.xpath("//a[text()='News']");
	private final By button_Contact = By.xpath("//a[text()='Contact']");
	private final By button_About = By.xpath("//a[text()='About']");
	
	public floatingMenuPage(Baseclass bs)
	{
		this.bs = bs;
	}
	
	
	public boolean verifyHomeButtonIsVisible()
	{
		return bs.checkElementExists(button_Home);
	}
	
	public boolean verifyContactButtonIsVisible()
	{
		return bs.checkElementExists(button_Contact);
	}
	
	public boolean verifyNewsButtonIsVisible()
	{
		return bs.checkElementExists(button_News);
	}
	
	public boolean verifyAboutButtonIsVisible()
	{
		return bs.checkElementExists(button_About);
	}
	
	public void scrollToBottomOfPage()
	{
		bs.scrollToElement(footerLink);
	}
	
}
