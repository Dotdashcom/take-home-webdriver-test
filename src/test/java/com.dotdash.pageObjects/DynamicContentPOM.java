package com.dotdash.pageObjects;

import com.dotdash.stepDefinitions.DynamicContentDef;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotdash.testUtils.TestBase;

public class DynamicContentPOM extends TestBase {

	@FindBy(css="div.example #content>div:nth-of-type(3)")
	WebElement thirdImg;
	
	public DynamicContentPOM() {
		PageFactory.initElements(driver,this);
	}
	
	public String userCheckPageContent() {
		String pageSrc1=driver.getPageSource();
		return pageSrc1;
	}
	
	public void userRefreshesPage() {

		driver.navigate().refresh();
	}
	
	public String usercheckPageContentAfterRefresh() {
		String pageSrc2=driver.getPageSource();
		return pageSrc2;
	}
	

}
