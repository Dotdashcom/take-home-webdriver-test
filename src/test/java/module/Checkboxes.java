package module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuration.PageLoader;

public class Checkboxes {
	
	private WebDriver driver = null;
	private List<WebElement> checkboxes = null;
	
	public Checkboxes(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		this.checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));
	}
	
	public void toggleCheckbox(int index) {
		this.checkboxes.get(index).click();
	}
	
	public void setCheckbox(int index, boolean selected) {
		if ((selected != isChecked(index))) {
			toggleCheckbox(index);
		}					
	}
	
	public boolean isChecked(int index) {
		return this.checkboxes.get(index).isSelected();
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/checkboxes");		
	}
	
	
}
