package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseutils;

public class DynamicContentPage extends baseutils{
	
	//call baseutils class
	baseutils bu = new baseutils();
	
	//create a constructor
	public DynamicContentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//loactor for refresh
	@FindBy (linkText = "click here")
	WebElement lnkRefresh ;
	
	//locators for the content
	@FindBy (xpath = "//div[@class='large-10 columns']")
	List<WebElement> txtContent;
	
	//locators for the content
	@FindBy (xpath = "(//div[@class='large-10 columns'])[2]")
	WebElement txtContent1;
	
	//locators for the content2
	@FindBy (xpath = "(//div[@class='large-10 columns'])[2]")
	WebElement txtContent2;
	
	//locators for the content3
	@FindBy (xpath = "(//div[@class='large-10 columns'])[3]")
	WebElement txtContent3;
		
	//methods for getting the content from list
	public boolean DynamicContent1() {
		boolean val1 = bu.handlingDynamicContents(txtContent1, lnkRefresh, "Content1");
		return val1;
	}
	
	public boolean DynamicContent2() {
		boolean val2 = bu.handlingDynamicContents(txtContent2, lnkRefresh, "Content2");
		return val2;
	}
	
	public boolean DynamicContent3() {
		boolean val3 = bu.handlingDynamicContents(txtContent3, lnkRefresh, "Content3");
		return val3;
	}
	
}
