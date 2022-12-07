package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicContentPage extends BasePage {
	
	private String page = "dynamic_content";
	private String page_append = "?with_content=static";
	
	private String rowsCss = "#content > .row";
	
	private List<WebElement> allContent;

	public DynamicContentPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}

	public void refreshContents() {
		allContent = driver.findElements(By.cssSelector(rowsCss));
	}
	
	public List<WebElement> getAllContent() {
		return allContent;
	}
	
	public WebElement getContentByIndex(int index) {
		return allContent.get(index);
	}
	
	public String getImgUrlFromContent(WebElement content) {
		String imgUrl = content.findElement(By.className("large-2")).findElement(By.tagName("img")).getAttribute("src");
		return imgUrl;
	}
	
	public String getTextFromContent(WebElement content) {
		String text = content.findElement(By.className("large-10")).getText();
		return text;
	}
	

	public void goToPage() {
		driver.get(getUrl());
	}
	
	public void goToPageWithAppend() {
		driver.get(getUrl()+page_append);
	}

	public void openPage(String url) {
		driver.get(url);
	}

}
