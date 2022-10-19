package pagepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.BaseTest;

public class Dynamiccontrol extends BaseTest {

	public Dynamiccontrol() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='checkbox-example']/button")
	private static WebElement Remove;
	
	@FindBy(xpath="//*[@id='input-example']/input")
	private static WebElement emptyelement;
	
	@FindBy(xpath="//*[@id='input-example']/button")
	private static WebElement Enable;
	
	@FindBy(xpath="//*[@id='checkbox']/input")
	private static WebElement ACheckbox;
	
	@FindBy(xpath="//*[@id='checkbox-example']/button")
	private static WebElement Add;
	
	@FindBy(xpath="//*[@id='input-example']/button")
	private static WebElement Disable;
	
	public boolean ACheckbox() {
		wait = new WebDriverWait(driver,5);
		if(Remove.isEnabled()) {
		Remove.click();
		}
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='checkbox']/input")));
	}
	
	public void Removebutton() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(Remove));
		if(Remove.isEnabled())
			Remove.click();
	}
	
	public boolean Addbutton() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(Remove));
		if(Add.isEnabled())
			Add.click();
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='checkbox']/input"))).FALSE;
	}
	
	public void Enable() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(Enable));
		if(Enable.isEnabled())
			Enable.click();
	}
	
	public boolean Disable() {
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(Disable));
		if(Disable.isEnabled())
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='input-example']/button")));
		return true;
	}
	
	public boolean empty() {
		if(Enable.isEnabled())
			Enable.click();
		wait = new WebDriverWait(driver,5);
		return wait.until(ExpectedConditions.elementToBeClickable(emptyelement)).isEnabled();
	}
	
	

}