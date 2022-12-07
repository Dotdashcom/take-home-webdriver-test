package PageObjects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class DynamicContentPage extends BasePage {
	@FindBy (css = "#content>div.row>div.large-10.columns")
	List <WebElement> rows;
	public DynamicContentPage (Config testConfig) {
		super(testConfig);
	}
	public ArrayList <String> getPageContent() {
		ArrayList <String> textOnPage = new ArrayList <>();
		for (WebElement row : rows) {
			textOnPage.add(row.getText());
		}
		return textOnPage;
	}
}
