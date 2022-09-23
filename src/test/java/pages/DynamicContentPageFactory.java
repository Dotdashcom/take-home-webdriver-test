package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class DynamicContentPageFactory extends CommonMethods {
	
	@FindBy (xpath = "(//div[@class='row']/div[2])[1]")
	public WebElement firstText;
	
	@FindBy (xpath = "(//div[@class='row']/div[2])[2]")
	public WebElement secondText;
	
	@FindBy (xpath = "(//div[@class='row']/div[2])[3]")
	public WebElement thirdText;
	
	
	public DynamicContentPageFactory() {
		PageFactory.initElements(driver, this);
	}

}
