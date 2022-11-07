package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {
	@FindBy(xpath="//body[@id='tinymce']")
	private WebElement searchIFrame;
	
	public IFramePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void searchiframe() {
		searchIFrame.clear();
		searchIFrame.sendKeys("Frame inside");
	}
	
	public String getTextFromiframe() {
		return searchIFrame.getText();
	}

}
