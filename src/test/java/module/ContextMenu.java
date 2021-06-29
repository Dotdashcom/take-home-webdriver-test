package module;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class ContextMenu {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="hot-spot")
	private WebElement hotspot;
	
	public ContextMenu(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);
	}
	
	public void rightClickHotspot() {
		Actions actions = new Actions(driver);
		actions.contextClick(hotspot).perform();		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch(NoAlertPresentException ex) {
			return false;
		}		
	}
	
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void acceptAlert() {		
		Alert alert = driver.switchTo().alert();
		alert.accept();	
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/context_menu");		
	}
}
