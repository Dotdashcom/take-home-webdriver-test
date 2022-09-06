package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class DropDown extends Driver {
	
			//Locators
			public static By DropDownBtn = By.xpath("//Select[@id='dropdown']");
			

			// Navigate to Login page
			public static void NavigateToDropDownPage()
			{

				Driver.Instance.get(Baseurl+"//dropdown");
			
			}
			
			//Select dropdown option 1
			
			public static String SelectDropDown1() {
				Select sel1 = new Select(Driver.Instance.findElement(By.xpath("//*[@id='dropdown']")));
				//Select dropdown option 1
				sel1.selectByValue("1");
				WebElement option = sel1.getFirstSelectedOption();
						String SelectedText = option.getText();
						return SelectedText;
			}
			
				//Select drop down option 2
			
			public static String SelectDropDown2() {
				Select sel2 = new Select(Driver.Instance.findElement(By.xpath("//*[@id='dropdown']")));
				//Select dropdown option 1
				sel2.selectByValue("2");
				WebElement option = sel2.getFirstSelectedOption();
				String SelectedText = option.getText();
				return SelectedText;
			}
			

}
