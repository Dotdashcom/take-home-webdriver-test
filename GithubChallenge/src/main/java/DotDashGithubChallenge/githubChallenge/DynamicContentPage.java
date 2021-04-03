package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends TestBase {
 public DynamicContentPage(WebDriver driver) {
	 super(driver);
}
 @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[1]/img")
 private WebElement displayedPicture;
 
 @FindBy(xpath = "//*[@id=\"content\"]/div/p[2]/a")
 private WebElement refreshBtn;
 
 public void verifyDynamicContent() {
	 
		for (int i = 0; i < 3; i++) {
			refreshBtn.click();
			assertEquals(false, displayedPicture.getText() == "/img/avatars/Original-Facebook-Geek-Profile-Avatar-3.jpg" );
		}

 }
}
