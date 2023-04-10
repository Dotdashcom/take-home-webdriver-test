package navpreet.pageobjects;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPageObjects {

	WebDriver driver;
	Set<String> windows;
	public MultipleWindowsPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Multiple Windows']")
	private WebElement mutiple_windows;
	
	@FindBy(xpath="//a[@href='/windows/new']")
	private WebElement click_here;
	
	public void ClickWindows()
	{
		mutiple_windows.click();
	}
	
	public void Click_ClickHere()
	{
		click_here.click();
	}
	
	public String openAndSwitchToNewWindow() {
		Click_ClickHere();
		windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		return driver.getCurrentUrl();
	}
	
	public String Check_NewTabTitle()
	{
		return driver.getCurrentUrl();
	}
}
