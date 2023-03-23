package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BaseClass {

	public DropDownPage(){
		PageFactory.initElements(driver, this);
	}
	
 @FindBy(xpath="//*[@id='dropdown']")
 private WebElement dropDown;
 
 @FindBy(xpath = "//*[@id='content']/div/h3")
 private WebElement text;
 
 public String selectDropdown(int index)  {
	 System.out.println("In drpdown page");
	 
	 Select drpDwn = new Select(dropDown);
	 dropDown.click();
	System.out.println("value selected");
	 drpDwn.selectByIndex(2);
	 text.click();
	 System.out.println("clicking on the text"); 
	 String value =dropDown.getAttribute("value");
	 System.out.println("The  value is: "+value);
	 return value;
 }
 
}
