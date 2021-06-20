package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
		//TODO:  use base url variable
		driver.get("http://localhost:7080/dynamic_content");
	}
	
	
}
