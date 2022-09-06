package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu extends Driver {
	
	
		//Locators
		public static By box = By.xpath("//div[@id='hot-spot']");
		
		
		
		//Actions Driver Initiate
		static  Actions actions = new Actions(Driver.Instance);
	
		// Navigate to Login page
		public static void NavigateToContextMenuPage()
		{

			Driver.Instance.get(Baseurl+"//context_menu");
		
		}
		
		// Right Click on Box and handle alert
				public static void RightClickBox()
				{
					WebElement rightClick = Driver.Instance.findElement(box);
					actions.contextClick(rightClick).perform();
				
				}
		
		// handle alert and get Text
				public static String HandleAlertAndGetText()
				{
					String AlertMessage = Driver.Instance.switchTo().alert().getText();
					Driver.Instance.switchTo().alert().accept();
					return AlertMessage;

				}
				

}
