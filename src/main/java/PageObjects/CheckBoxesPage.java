package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class CheckBoxesPage extends BrowserUtilities {
	public CheckBoxesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='checkboxes']/input[1]")
	public WebElement checkbox1;

	@FindBy(how = How.XPATH, using = "//*[@id='checkboxes']/input[2]")
	public WebElement checkbox2;
	
	@FindAll({@FindBy(xpath = "//*[@type='checkbox']")})
	public List<WebElement> listOfCheckboxes;
	
	public void getUrl() {
		driver.get(BaseTest.getURL("checkboxes"));
	}
	public void selectCheckbox(WebElement element) {
		fnClickWebElement(element);	
	}
	public List<WebElement> getCheckBoxList(){
		return listOfCheckboxes;
		
	}
	
}
