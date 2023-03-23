package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage extends BaseClass {
public static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
	public DynamicLoadingPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='start']/button")
	 private WebElement startButton;
	
	public String clickTestButton() {
		System.out.println("in click Test page");
		startButton.click();
		System.out.println("clicked test");
		String text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4"))).getText();
		System.out.println("Text is: "+text);
		return text;
	}
}
