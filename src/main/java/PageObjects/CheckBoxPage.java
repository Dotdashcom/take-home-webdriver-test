package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
	@FindBy(xpath="//input[1]")
	private WebElement searchChecbox1;
	
	@FindBy(xpath="//input[2]")
	private WebElement searchChecbox2;
	
	public CheckBoxPage(WebDriver driver){
		PageFactory.initElements(driver,this);
		}
	
 public boolean selectCheckBox1() {
	searchChecbox1.click();
	return searchChecbox1.isSelected();
		}
 
 public boolean selectCheckBox2() {
		searchChecbox2.click();
		return searchChecbox2.isSelected();
			}

}
