package pomPackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseClass;

public class PomDropDown extends BaseClass {
	
	Select option ;
	public PomDropDown() {
		
		PageFactory.initElements(driver, this);
	}
  @FindBy (id= "dropdown") WebElement dropdown;
  
  @FindBy(xpath = "//*[@id=\"dropdown\"]/option[2]") WebElement option1;
  
  @FindBy (xpath = "//*[@id=\"dropdown\"]/option[3]") WebElement option2;
  
  
  public void selectdropdown() throws InterruptedException {
	  
	  option= new Select(dropdown);
	  
	  option.selectByValue("1");
	  
	  Thread.sleep(5000);
	  option.selectByValue("2");
	  Thread.sleep(5000);
  }
  
	public String option1displayed() {
		
		WebElement optext = option.getFirstSelectedOption();
		
		String text = optext.getText();
		
		
		return text;
		
		
		
	}
	
	
}
