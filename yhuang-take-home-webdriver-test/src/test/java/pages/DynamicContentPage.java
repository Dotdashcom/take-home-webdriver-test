package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BaseDriver{
	public DynamicContentPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(xpath="//div[@id='content']//div[@class='large-10 columns']")
	public List<WebElement> contentElements;
	
	public List<String> getCurrentContentsList(){
		List<String> contentStrings = new ArrayList<String>();
		for(WebElement element : contentElements) {
			contentStrings.add(element.getText().trim());
		}
		return contentStrings;
	}
}
