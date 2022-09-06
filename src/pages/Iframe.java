package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Iframe extends Driver {
	
			//Locators
			public static By iframe = By.className("tox-edit-area__iframe");
			public static By Edit = By.className("mce-content-body");
			public static By Para = By.xpath("//*[@id='tinymce']/p");
			
		
			//initiate wait
			static WebDriverWait wait = new WebDriverWait(Driver.Instance,Duration.ofSeconds(20));
			// Navigate to Login page
			public static void NavigateToIframePage()
			{

				Driver.Instance.get(Baseurl+"//iframe");
			
			}
			
			//Switch to iframe
			public static void SwitchToIframe() {
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

			}
			
			//Write Text
			public static void WriteInIframe(String message) {
				Driver.Instance.findElement(Edit).clear();
				Driver.Instance.findElement(Edit).sendKeys(message);
			}
			
			//GetText
			
			public static String GetText() {
				String Text = Driver.Instance.findElement(Para).getText();
				return Text;
			}

}
