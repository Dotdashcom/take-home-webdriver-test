package pageObjects;

import org.openqa.selenium.WebDriver;

public class DynamicContentPage extends BaseTemplate{

	public DynamicContentPage(WebDriver driver) {
		super(driver);
	}
	
	public String fetchPageSource()
	{
		return driver.getPageSource();
	}
	
	public void refreshPage()
	{
		driver.get(driver.getCurrentUrl());
	}
	

}
