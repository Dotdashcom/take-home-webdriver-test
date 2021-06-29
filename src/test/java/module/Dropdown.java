package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import configuration.PageLoader;

public class Dropdown {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="dropdown")
	private WebElement dropdown;
	
	public Dropdown(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);
	}
	
	public void selectOption(String text) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);		
	}
	
	public String getSelectedValue() {
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
		
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/dropdown");		
	}
	
	
	
	
}
