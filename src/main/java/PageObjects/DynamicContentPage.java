package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
	@FindBy(xpath="//a[contains(text(),'click here')]")
	private WebElement searchClick;
	@FindBy(xpath="//div[@class='large-10 columns']")
	private WebElement searchText;
	
	public DynamicContentPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clicklink() {
		searchClick.click();
	}
	public String getteext() {
		return searchText.getText();
	}

}
