package pageObjectModel;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpeningNewTabPage {
	private WebDriver driver;

	public OpeningNewTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Click Here']")
	private WebElement linkField;
	
	@FindBy(how = How.XPATH, using = "//h3[text()='New Window']")
	private WebElement newTabMsg;
	
	public String openTabs() {
		linkField.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		return newTabMsg.getText();		
	}
}
