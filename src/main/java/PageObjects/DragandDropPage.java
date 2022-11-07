package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DragandDropPage {
	@FindBy(xpath="//div[@id='column-a']")
	private WebElement searchDragandDropA;
	
	@FindBy(xpath="//div[@id='column-b']")
	private WebElement searchDragandDropB;
	
	public DragandDropPage(WebDriver driver){
		PageFactory.initElements(driver,this);
		}
	public WebElement searchdraganddropa() {
		return searchDragandDropA;
		}
	
	public WebElement searchdraganddropb() {
		return searchDragandDropB;
  }
	
}