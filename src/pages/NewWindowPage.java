package pages;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.TestBase;

public class NewWindowPage extends TestBase{
	@FindBy(xpath="//a[contains(text(),'Click Here')]")
	WebElement Link;
	@FindBy(xpath="//h3[contains(text(),'New Window')]")
	WebElement NewWindow;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/windows");	
	}
	public void clickOnLink() {
		Link.click();
	}
	public String verifyText() {
		Set <String> allwindows=driver.getWindowHandles();
		Iterator<String> itr=allwindows.iterator();
		String mainwindow=itr.next();
		String childwindow=itr.next();
		driver.switchTo().window(childwindow);
		return NewWindow.getText();
		
	}
	public void closeBrowser() {
		driver.quit();
	}
}
