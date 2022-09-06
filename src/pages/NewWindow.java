package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewWindow extends Driver {
	
			//Locators
			public static By NewWindowBtn = By.xpath("//a[contains(text(),'Click Here')]");
			public static By NewWindowText = By.tagName("h3");

			
			// Navigate to NewWindowPage page
			public static void NavigateToContextMenuPage()
			{

				Driver.Instance.get(Baseurl+"//windows");
			
			}
			
			//Click New Window Button
			public static void ClickLinkAndGotoNewWindow() {
				String ParentHandle = Driver.Instance.getWindowHandle();
				
				Driver.Instance.findElement(NewWindowBtn).click();
				
				//Loop through until we find a new window handle
				for (String windowHandle : Driver.Instance.getWindowHandles()) {
				    if(!ParentHandle.contentEquals(windowHandle)) {
				        Driver.Instance.switchTo().window(windowHandle);
				        break;
				    }
				}
	            
			}
			
			//GetTextinNewWindow
			public static String GetTextInNewWindow() {
				String message = Driver.Instance.findElement(NewWindowText).getText();
				return message;
			}
			

}
