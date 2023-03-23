package pages;

import java.util.Set;
import java.util.Iterator;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newWindowPage extends BaseClass {
	public static String parentWindow;
	public String childWindow;
	public newWindowPage(){
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//*[@id='content']/div/a")
 private WebElement linkClickHere;
 
 @FindBy(xpath="//*[@class='example']")
 private WebElement newWindowText;
 
 public String clickLink() {
	 parentWindow = driver.getWindowHandle(); 
	 linkClickHere.click();
	 Set<String>s=driver.getWindowHandles();
	 Iterator<String> I1=s.iterator();
	 while(I1.hasNext())
	 {

	 String child_window=I1.next();


	 if(!parentWindow.equals(child_window))
	 {
	 driver.switchTo().window(child_window);

	 System.out.println(driver.switchTo().window(child_window).getTitle());
	 
 }
 }
	 String windowText = newWindowText.getText();
	 System.out.println("window text is; "+windowText);
	 return windowText;
 }
}
 

 

