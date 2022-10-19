package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class Dynamiccontent extends BaseTest {

	public Dynamiccontent() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#content > div:nth-child(1) > div.large-2.columns > img")
	private static WebElement dynamicmsg1;
	
	@FindBy(css="#content > div:nth-child(4) > div.large-2.columns > img")
	private static WebElement dynamicmsg2;
	
	@FindBy(css="#content > div:nth-child(7) > div.large-2.columns > img")
	private static WebElement dynamicmsg3;
	
	private static Dynamiccontent dynamiccontent;
	
	private static String content1;
	private static String content2;
	private static String content3;
	
	public String DynamicContent1() {
		driver.navigate().refresh();
		content1 = dynamicmsg1.getAttribute("src").toString();
		return content1;
	}
	
	public String DynamicContent2() {
		driver.navigate().refresh();
		content2 = dynamicmsg2.getAttribute("src").toString();
		return content2;
	}
	
	public String DynamicContent3() {
		driver.navigate().refresh();
		content3 = dynamicmsg3.getAttribute("src").toString();
		return content3;
	}
	
	public void DynamiccontentAssertion() {
		dynamiccontent=new Dynamiccontent(); 
		if(DynamicContent1()!= null)
		Assert.assertNotEquals(dynamiccontent.DynamicContent1(), dynamiccontent.DynamicContent2());
		
		else if(DynamicContent2()!=null)
			Assert.assertNotEquals(dynamiccontent.DynamicContent2(), dynamiccontent.DynamicContent3());
		
		else if(DynamicContent3()!=null)
			Assert.assertNotEquals(dynamiccontent.DynamicContent3(),dynamiccontent.DynamicContent1());
	}
	
}