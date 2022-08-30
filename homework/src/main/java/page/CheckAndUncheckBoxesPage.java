package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckAndUncheckBoxesPage {

	WebDriver driver;

	public CheckAndUncheckBoxesPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Checkboxes')]")
	WebElement CHECKBOXES_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	List<WebElement> CHECKBOXES_ELEMENT_SELECT;

	public void clickCheckBox()  {
		//Thread.sleep(2000);
		CHECKBOXES_ELEMENT.click();
		//Thread.sleep(5000);
	}

	public void checkBoxSelect() throws InterruptedException {

		//Thread.sleep(2000);
		// checking if the all checkboxes are not selected
		for (int i = 0; i < CHECKBOXES_ELEMENT_SELECT.size(); i++) {

			if (CHECKBOXES_ELEMENT_SELECT.get(i).isSelected()) {
				CHECKBOXES_ELEMENT_SELECT.get(i).click();
			}
		}

		// selecting all checked boxes
		Thread.sleep(2000);
		for (int i = 0; i < CHECKBOXES_ELEMENT_SELECT.size(); i++) {
			CHECKBOXES_ELEMENT_SELECT.get(i).click();
		}

		// validating if checkbox is selected
		for (int i = 0; i < CHECKBOXES_ELEMENT_SELECT.size(); i++) {
			boolean status = CHECKBOXES_ELEMENT_SELECT.get(i).isSelected();
			if (status) {
				System.out.println("check box is selected");
			} else {
				System.out.println("check box is not clicked");
			}

		}

		// unselecting all checked boxes
		Thread.sleep(2000);
		for (int i = 0; i < CHECKBOXES_ELEMENT_SELECT.size(); i++) {
			CHECKBOXES_ELEMENT_SELECT.get(i).click();

		}

		// validating if checkbox is selected
		for (int i = 0; i < CHECKBOXES_ELEMENT_SELECT.size(); i++) {
			boolean status = CHECKBOXES_ELEMENT_SELECT.get(i).isSelected();
			if (status) {
				System.out.println("check box is selected");
			} else {
				System.out.println("check box is Unselected");
			}
		}
	}

}
