package webtests.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_006_DynamicContent_POM extends WT_BaseClass{
  
	//Locators
	@FindBy (xpath= "//div[@id='content']")
	WebElement Contents;
	
	@FindBy(css="#content > div:nth-child(1) > div.large-2.columns > img")
	  WebElement dynamicpic1;
	
	@FindBy(css="#content > div:nth-child(4) > div.large-2.columns > img")
	WebElement dynamicpic2;
	
	@FindBy(css="#content > div:nth-child(7) > div.large-2.columns > img")
	WebElement dynamicpic3;
	
	//Constructor
	public WT_006_DynamicContent_POM() {
		PageFactory.initElements(driver,this );
	}
	
	private static String content1;
    private static String content2;
    private static String content3;
	 
    public String DynamicContent1() {
		driver.navigate().refresh();
		content1= dynamicpic1.getAttribute("src").toString();
		return content1;
	}
    public String DynamicContent2() {
		driver.navigate().refresh();
		content2= dynamicpic2.getAttribute("src").toString();
		return content2;
    }
    public String DynamicContent3() {
		driver.navigate().refresh();
		content3= dynamicpic3.getAttribute("src").toString();
		return content3;
    }}