package dotDashcom.pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
	WebDriver driver;

	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div[class='large-10 columns']")
	private List<WebElement> dynamicContent;

	public boolean checkChangingContent() {
		String oldText=null, newText=null;
		boolean isDifferent = false;

		for (WebElement oldList : dynamicContent) {
			oldText = oldList.getText();
		}
			refreshPage();

			for (WebElement newList :dynamicContent) {
				newText = newList.getText();
			}
			if (!oldText.equals(newText)) {
				isDifferent = true;
			}
		
		return isDifferent;
	}

	public void refreshPage() {

		driver.navigate().refresh();

	}
}
