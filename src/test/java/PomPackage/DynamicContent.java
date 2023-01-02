package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class DynamicContent extends BaseClass {
	
	@FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
	public WebElement text1;

	@FindBy(xpath = "(//div[@class='large-10 columns'])[2]")
	public WebElement text2;

	public DynamicContent() {
		PageFactory.initElements(driver, this);
	}

}
