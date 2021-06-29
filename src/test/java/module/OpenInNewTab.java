package module;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class OpenInNewTab {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.LINK_TEXT, using="Click Here")
	private WebElement clickHere;
	
	public OpenInNewTab(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);
	}
	
	public void clickLinkToLaunchNewTab() {
		clickHere.click();		
	}
	
	public String getTextFromTab() {
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		String nextHandle = (String)handles.toArray()[1];
		
		System.out.println("Was on window handle:" + currentHandle);
		System.out.println("Will switch to window handle:" + nextHandle);
		
		driver.switchTo().window(nextHandle);
		return driver.findElement(By.tagName("h3")).getText();
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/windows");		
	}
	
}
