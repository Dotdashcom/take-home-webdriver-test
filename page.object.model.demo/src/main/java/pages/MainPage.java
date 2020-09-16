package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageInitElements{
	
	@FindBy(xpath = "//h1[text()='Welcome to the-internet']")
	private WebElement MainPageTxt;
	
	public MainPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public String welcomeMainPage() {
		String welcometxt = MainPageTxt.getText();
		return welcometxt;
	}
	
	public String TitleMainPage() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

}
