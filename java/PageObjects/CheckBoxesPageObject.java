
package PageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPageObject {

	WebDriver driver;
	
	public CheckBoxesPageObject(WebDriver driver) 
	{
		this.driver= driver;
	}
	
	public void Selectcheckbox() {
	By Checkbox= By.xpath("//input[@type = 'checkbox']");
	List<WebElement> Checkboxes =driver.findElements(Checkbox);
	System.out.println(Checkboxes.size());
	for (WebElement checkbox:Checkboxes)
	{
		checkbox.click();
		checkbox.isSelected();
		checkbox.click();
		checkbox.isSelected();
	}
	{System.out.println(Checkboxes.size());}
	
	}
	}
	
