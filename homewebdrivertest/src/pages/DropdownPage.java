package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownPage extends BasePage{
	
	private String page = "dropdown";
	
	private String dropdownOptionCss = "#dropdown > option";
	private List<WebElement> dropdownOptions;


	public DropdownPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	public void getOptions() {
		dropdownOptions = driver.findElements(By.cssSelector(dropdownOptionCss));
	}
	
	public WebElement getSelectedOptions() {
		for (WebElement webElement : dropdownOptions) {
			if(webElement.isSelected())
				return webElement;
		}
		return null;
	}

	
	public void goToPage() {
		driver.get(getUrl());
	}

	public void openPage(String url) {
		driver.get(url);
	}
	
	public void setDropdownOptions(List<WebElement> dropdownOptions) {
		this.dropdownOptions = dropdownOptions;
	}
	
	public List<WebElement> getDropdownOptions() {
		return dropdownOptions;
	}
}
