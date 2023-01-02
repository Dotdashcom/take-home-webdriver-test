package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class DynamicLoading extends BaseClass{
	@FindBy(xpath = "//button[.='Start']")
	public WebElement startBtn;

	@FindBy(id = "finish")
	public WebElement msg;

	public DynamicLoading() {
		PageFactory.initElements(driver, this);
	}

}
