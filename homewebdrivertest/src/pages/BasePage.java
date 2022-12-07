package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	private String url;
	private String baseUrl;
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		baseUrl = "http://localhost:7080/";
		this.driver = driver;
	}
	
	public void setPageUrl(String page) {
		url = baseUrl + page;
	}
	
	public String getUrl() {
		return url;
	}
	

	public void goToPage() {
		driver.get(getUrl());
	}

	public void openPage(String url) {
		driver.get(url);
	}
}
