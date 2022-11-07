package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {
	@FindBy(xpath="//div[@class='example']//div[1]//img[1]")
	private WebElement searchImage1;
	
	@FindBy(xpath="//div[@class='example']//div[2]//img[1]")
	private WebElement searchImage2;
	
	@FindBy(xpath="//div[@class='example']//div[3]//img[1]")
	private WebElement searchImage3;
	
	public MouseHoverPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement image1() {
		return searchImage1;
	}

	public WebElement image2() {
		return searchImage2;
	}
	
	public WebElement image3() {
		return searchImage3;
	}
}
