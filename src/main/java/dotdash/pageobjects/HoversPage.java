package dotdash.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HoversPage {

public WebDriver driver;

	

	@FindBy(xpath="//div[@class='example']/div[1]")
	private WebElement firstAvatar;
	
	@FindBy(xpath="//div[@class='example']/div[2]")
	private WebElement secondAvatar;
	
	@FindBy(xpath="//div[@class='example']/div[3]")
	private WebElement thirdAvatar;
	
	@FindBy(xpath="//div[@class='figcaption']/h5")
	private WebElement caption1;
	
	@FindBy(xpath="//div[@class='figcaption']/a")
	private WebElement caption2;
	
	public HoversPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void hoverAndVerifyCaption(String text)  {
		Actions a = new Actions(driver);
		if(text.equalsIgnoreCase("firstavatar")) {
			a.moveToElement(firstAvatar);
			caption1.isDisplayed();
			caption2.isDisplayed();
		} else if(text.equalsIgnoreCase("secondavatar")) {
			a.moveToElement(secondAvatar);
			caption1.isDisplayed();
			caption2.isDisplayed();
		} else if(text.equalsIgnoreCase("thirdavatar")) {
			a.moveToElement(thirdAvatar);
			caption1.isDisplayed();
			caption2.isDisplayed();
		} else {
			System.out.println("No Avatar Found");
		}
	}

}
