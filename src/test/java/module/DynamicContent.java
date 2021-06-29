package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class DynamicContent {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="content")
	private WebElement content;
	
	public DynamicContent(WebDriver driver) {
		this.driver = driver;
		this.loadPage();		
		PageFactory.initElements(driver, this);
	}
	
	public String getDynamicContent() {
		return content.getText();
	}
		
	public void loadPage() {
		PageLoader.loadPage(driver, "/dynamic_content");		
	}
	
}
