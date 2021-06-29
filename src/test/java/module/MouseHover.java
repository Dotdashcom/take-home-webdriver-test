package module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.PageLoader;

public class MouseHover {
	
	private WebDriver driver = null;
	private List<WebElement> images;
	
	@FindBy(how=How.TAG_NAME, using="button")	
	private WebElement startButton;
	
	public MouseHover(WebDriver driver) {
		this.driver = driver;
		this.loadPage();		
		images = driver.findElements(By.className("figure"));
	}
	
	public void hoverOverImage(int index) {
		 Actions action = new Actions(driver);
		 action.moveToElement(images.get(index)).build().perform();
		
	}
	
	public String getVisibleCaptionFor(int index) {
		List<WebElement> captions = driver.findElements(By.className("figcaption"));
		return captions.get(index).getText();
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/hovers");		
	}
	
	
}
