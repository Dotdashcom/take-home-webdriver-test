package DotDashGithubChallenge.githubChallenge;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends TestBase{

	public NotificationMessagePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@href='/notification_message']")
    private WebElement messageLink;

    @FindBy(id = "flash")
    private WebElement notificationText;
	
	public boolean verifyNotificationMessage(List <String> possibleMessages) {
		for (int i = 0; i < 3; i++) {
            messageLink.click();
            String message = notificationText.getText().replace("\n×", "");
            if (!possibleMessages.contains(message)) {
                return false;
            }
        }
        return true;
    }
	
}
