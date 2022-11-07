package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpenInNewWindowPage {
	@FindBy(xpath="//a[contains(text(),'Click Here')]")
	private WebElement searchClickHere;
	
	@FindBy(how=How.CLASS_NAME,using="example")
	private  WebElement searchnewwindow;
	
	
	
	
	public OpenInNewWindowPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickhere() {
		searchClickHere.click();
	}

	public String gettext() {
		return searchnewwindow.getText();
	}
}
