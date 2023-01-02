package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class JsAlert extends BaseClass {
	@FindBy(xpath = "(//button)[1]")
	public WebElement jsArt;

	@FindBy(xpath = "(//button)[2]")
	public WebElement jsCon;

	@FindBy(xpath = "(//button)[3]")
	public WebElement jsPro;

	@FindBy(xpath = "//p[@id='result']")
    public WebElement msg;

	public JsAlert() {
		PageFactory.initElements(driver, this);
	}

}
