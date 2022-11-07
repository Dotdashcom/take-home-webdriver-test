package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
	@FindBy(how=How.ID,using="dropdown")
	  private WebElement selectdropdown;
	
	@FindBy(xpath="//option[contains(text(),'Option 1')]")
	  public static WebElement selectObject1;
	

	@FindBy(xpath="//option[contains(text(),'Option 2')]")
	  public static WebElement selectObject2;
	
	public DropDownPage(WebDriver driver) { 
		PageFactory.initElements(driver,this);
	}
	
	public Select selectDropDown() {
	 Select selc=new Select(selectdropdown);
	 return selc;
	}
	
	public void selectobject1() {
		selectDropDown().selectByIndex(1);
		}
	
	public void selectobject2() {
		selectDropDown().selectByIndex(2);
		}
	
}