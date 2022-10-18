package webtests.Pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webtests.BasePackage.WT_BaseClass;

public class WT_002_Checkbox_POM extends WT_BaseClass{
     
	//Locators
    @FindBy(xpath= "//form[@id='checkboxes']")	
     List<WebElement> Checkboxes;
  
    @FindBy(xpath = "//input[@type='checkbox'][1]")
    WebElement Checkbox1;
  
    @FindBy(xpath = "//input[@type='checkbox'][2]")
    WebElement Checkbox2;
  
    //Constructor
    public WT_002_Checkbox_POM() {
    PageFactory.initElements(driver,this );
  }
    
    
  public void checkbox1() {
	  Checkbox1.click();
	
  }
  public boolean ValidateCheckBox1() {
		return Checkbox1.isSelected();
	}
  
  public void checkbox2() {
	  Checkbox2.click();
  }
  public boolean ValidateCheckBox2() {
		return Checkbox2.isSelected();
	}
  }
  
  
