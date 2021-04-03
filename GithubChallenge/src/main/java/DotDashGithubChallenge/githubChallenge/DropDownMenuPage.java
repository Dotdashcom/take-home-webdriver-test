package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownMenuPage extends TestBase{
	
	public DropDownMenuPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "dropdown")
	private WebElement selectBox;
	
	public void verifySelectedOptions() {
		Select select = new Select(selectBox);
		select.selectByValue("1");
		select.selectByValue("2");
		
		List <WebElement> options = select.getAllSelectedOptions();
		
		for (WebElement option : options) {
			assertEquals(true,option.isSelected() );
		}
	}

}
