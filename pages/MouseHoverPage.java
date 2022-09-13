package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class MouseHoverPage extends TestBase{

	@FindBy(xpath="//div[@class='figure'][1]")
	WebElement User1;
	@FindBy(xpath="//h5[contains(text(),'name: user1')]")
	WebElement userName1;
	@FindBy(xpath="//div[@class='figure'][2]")
	WebElement User2;
	@FindBy(xpath="//h5[text()='name: user2']")
	WebElement userName2;
	@FindBy(xpath="//div[@class='figure'][3]")
	WebElement User3;
	@FindBy(xpath="//h5[text()='name: user3']")
	WebElement userName3;
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/hovers");
		
	}
	public void hoverOnUser1() {
		Actions builder=new Actions(driver);
		builder.moveToElement(User1).build().perform();
		
	}
	public String VerifyhoverOnUser1() {
		return userName1.getText();
		
	}
	public void hoverOnUser2() {
		Actions builder=new Actions(driver);
		builder.moveToElement(User2).build().perform();
	}
	public String VerifyhoverOnUser2() {
		return userName2.getText();
		
	}
	public void hoverOnUser3() {
		Actions builder=new Actions(driver);
		builder.moveToElement(User3).build().perform();

	}
	public String VerifyhoverOnUser3() {
		return userName3.getText();
		
	}
	public void closeBrowser() {
		driver.quit();
	}
}
