package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Util.TestBase;

public class DropDownPage extends TestBase {
	@FindBy(id="dropdown")
	 WebElement dropDown;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void LandingPage() {
		driver.get(BaseUrl+"/dropdown");
		
	}
	public String selectDropDown1() {
		Select s=new Select(dropDown);
		s.selectByVisibleText("Option 1");//select option 1
		String selection1=s.getFirstSelectedOption().getText();
		return selection1;
	}
	public String selectDropDown2() {
		Select s=new Select(dropDown);
		s.selectByVisibleText("Option 2");//select option 1
		String selection2=s.getFirstSelectedOption().getText();
		return selection2;
	}
	public void closeBrowser() {
		driver.quit();
	}

}
