package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class FloatingMenu extends Driver {
	
			//Locators
			public static By menu = By.xpath("//div[@id='menu']");
			
			static JavascriptExecutor js = (JavascriptExecutor)Driver.Instance;
			
			
			
			// Navigate to Login page
			public static void NavigateToFloatingMenuPage()
			{

				Driver.Instance.get(Baseurl+"//floating_menu");
			
			}
			
			//Scroll to the bottom of the page
			
			public static void ScrollToBottomOfThePage()
			{
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			}
			
			public static boolean ValidatefloatingMenuExists()
			{
				return Driver.Instance.findElement(menu).isDisplayed();
			}

}
