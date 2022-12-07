package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage extends BasePage{

	 private String page = "checkboxes";
	 
 	 private String checkboxesInputCss = "#checkboxes > input";
	 private List<WebElement> checkboxesList;
	
	public CheckboxPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	public void getCheckboxes() {
		checkboxesList = driver.findElements(By.cssSelector(checkboxesInputCss));
	}
	
	public void checkAllCheckboxes() {
		for (WebElement cb : checkboxesList) {
			if(!cb.isSelected()) {
				cb.click();
			}
			System.out.println(cb.getText());
		}
	}
	
	public void uncheckAllCheckboxes() {
		for (WebElement cb : checkboxesList) {
			if(cb.isSelected()) {
				cb.click();
			}
		}
	}
	
	public boolean isAllCheckboxesChecked() {
		boolean checked = true;
		for (WebElement cb : checkboxesList) {
			if(!cb.isSelected()) {
				checked = false;
			}
		}
		return checked;
	}

	public boolean isAllCheckboxesUnchecked() {
		boolean unchecked = true;
		for (WebElement cb : checkboxesList) {
			if(cb.isSelected()) {
				unchecked = false;
			}
		}
		return unchecked;
	}
	
	public void goToPage() {
		driver.get(getUrl());
	}

	public void openPage(String url) {
		driver.get(url);
	}

}
