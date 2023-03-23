package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import  org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage extends BaseClass{
	public static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
	public DynamicControlsPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='checkbox-example']/button")
	 private WebElement removeButton;
	@FindBy(xpath = "//*[@id='message']")
	 private WebElement itsGone;
	@FindBy(xpath = "//*[@id='checkbox-example']/button")
	 private WebElement addButton;
	@FindBy(xpath = "//*[@id='checkbox']")
	 private WebElement checkBox;
	@FindBy(xpath = "//*[@id='input-example']/button")
	 private WebElement enableButton;
	@FindBy(xpath = "//*[@id='input-example']/input")
	 private WebElement textBox;
	@FindBy(xpath = "//*[@id='input-example']/button")
	 private WebElement disableButton;
	
	public String clickRemoveButton() {
		System.out.println("in click remove page");
		removeButton.click();
		System.out.println("clicked remove");
		String text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[@id='message']"))).getText();
		System.out.println("Text is: "+text);
		return text;
	}
	
	public boolean clickAddButton() {
		System.out.println("in add button method");
		addButton.click();
		System.out.println("Add button clicked");
		boolean checkBoxFlag=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkbox']"))).isEnabled();
		System.out.println("Check box flag is: "+checkBoxFlag);
		return checkBoxFlag;
	}
	
	public boolean enableButton() {
		System.out.println("in enable button");
		enableButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']"))).isDisplayed();
		boolean textBoxFlag=textBox.isEnabled();
		System.out.println("textBoxFlag is: "+textBoxFlag);
		return textBoxFlag;
	}
	
	public boolean disableButton() {
		System.out.println("Disable button");
		disableButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']"))).isDisplayed();
		boolean disableFlag=textBox.isEnabled();
		System.out.println("disableFlag is: "+disableFlag);
		return disableFlag;
	}
}
