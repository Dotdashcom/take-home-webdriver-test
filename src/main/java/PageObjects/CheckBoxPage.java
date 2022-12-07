package PageObjects;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class CheckBoxPage extends BasePage {
	@FindBy (css = "#checkboxes > input[type=checkbox]")
	List <WebElement> checkBoxes;
	public CheckBoxPage (Config testConfig) {
		super(testConfig);
	}
	public void checkCheckBox(int choice, Boolean isChecked) {
		if (checkBoxes.get(choice).isSelected() != isChecked) {
			checkBoxes.get(choice).click();
		}
	}
	public boolean isChecked(int i) {
		return checkBoxes.get(i).isSelected();
	}
}
