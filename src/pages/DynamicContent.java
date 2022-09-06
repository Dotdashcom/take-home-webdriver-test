package pages;

import org.openqa.selenium.By;


public class DynamicContent extends Driver{
	
			//Locators
			public static By LastRowtext = By.xpath("//div[3]/div[2]");
			public static By LastRowimage = By.xpath("//div[3]/div[1]/img[1]");
			

			// Navigate to Login page
			public static void NavigateToDynamicContentPage()
			{

				Driver.Instance.get(Baseurl+"///dynamic_content");
			
			}
			
			//refresh page
			
			public static void RefreshPage() {
				Driver.Instance.navigate().refresh();
			}
			
			//Get the Text of element which chnages after refresh
			
			public static String GetText() {
				String  text = Driver.Instance.findElement(LastRowtext).getText();
				return text;
			}
			
			public static String GetAttribute() {
				String  text = Driver.Instance.findElement(LastRowimage).getAttribute("src");
				return text;
			}

}
