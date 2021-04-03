package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragandDropPage extends TestBase{

	public DragandDropPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "column-a")
	private WebElement source;

	@FindBy(id = "column-b")
	private WebElement target;
	
	@FindBy(id = "//div[@id='column-a']/header")
	private WebElement columnAHeader;

	@FindBy(id = "//div[@id='column-b']/header")
	private WebElement columnBHeader;
	
	public void verifyDragAndDrop() {
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(source).moveToElement(target).release().build().perform();
		
		String columnAText = columnAHeader.getText();
		String columnBText = columnBHeader.getText();
		assertEquals("A", columnBText);
		assertEquals("B", columnAText);
	}
	


}
