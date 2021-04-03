package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends TestBase{

	public CheckBoxPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"checkboxes\"]/input[1]")
	private WebElement checkboxOne;
	
	@FindBy (xpath = "//*[@id=\"checkboxes\"]/input[2]")
	private WebElement checkboxTwo;
	
	public void verifyCheckboxes() throws InterruptedException {
		
		
		checkboxOne.click();
		assertEquals(true,checkboxOne.isSelected());
		Thread.sleep(3000);
		
//		checkboxTwo.click();
		assertEquals(true,checkboxTwo.isSelected());
		Thread.sleep(3000);
		System.out.println("All check boxes has been checked");
		
				
		checkboxOne.click();
		assertEquals(false,checkboxOne.isSelected());
		Thread.sleep(3000);
		
		checkboxTwo.click();
		assertEquals(false,checkboxTwo.isSelected());
		Thread.sleep(3000);
		System.out.println("All check boxes has been unchecked");
		

	}
}
