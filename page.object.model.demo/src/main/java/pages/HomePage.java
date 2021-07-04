package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageInitElements{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//i[text()=' Logout']")
	private WebElement logoutBtn;

	public void logout()
	{
		logoutBtn.click();
	}
	
	public String loginSuccess() {
		String loginsuccesstxt = driver.findElement(By.xpath("//*[contains(text(),'You logged into a secure area!')]")).getText();
		return loginsuccesstxt;
	}

}
