package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DynamicContentPage {
	
private WebDriver driver;

	public DynamicContentPage(WebDriver driver ) {		
		this.driver = driver;
		
	}
	
	public  By passageText = By.cssSelector("div[class='large-10 columns']");
	
	@SuppressWarnings("null")
	public List<String> GetListOfPassages () {
		List <WebElement> listOfPassages = driver.findElements(passageText);		
		List<String> list1 = new ArrayList<String>();		
		for(WebElement a:listOfPassages){
			
			list1.add(a.getText());			
		}
		
		Collections.sort(list1);	
		
		return list1;
	}
	
	public Boolean BooleanIfListsAreEqual(List<String> list1, List<String> list2) {
		if(list1.equals(list2)) {
			return false;
		}
		return true;
	}

	public void VerifyIfListsAreEqual(List<String> list1, List<String> list2) {
		Assert.assertTrue(BooleanIfListsAreEqual(list1, list2));
	}
}
