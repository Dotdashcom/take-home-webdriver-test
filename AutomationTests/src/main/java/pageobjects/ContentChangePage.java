package pageobjects;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class ContentChangePage {
	public WebDriver driver;

	public ContentChangePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//div[@id='content']/div/div/div/div/div[2]")
	 WebElement firstpara;

	@FindBy(xpath="//div[@id='content']/div/div/div/div[2]/div[2]")
	 WebElement secondpara;

	@FindBy(xpath="//div[@id='content']/div/div/div/div[3]/div[2]")
	 WebElement thirdpara;

	public WebElement getfirstPara() {
		return firstpara;
	}
	public WebElement getsecondPara() {
		return secondpara;
	}
	public WebElement getthirdPara() {
		return thirdpara;
	}



}
