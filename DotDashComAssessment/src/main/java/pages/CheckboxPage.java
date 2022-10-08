package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class CheckboxPage extends PageObjectBase {

	public CheckboxPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public CheckboxPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public CheckboxPage returnStatusOfCheckboxes() {

		WebElement checkbox1 = this.getDriver().findElement(By.xpath("//input[@type='checkbox'][position()=1]"));
		System.out.println("The first checkbox  selection state is " + checkbox1.isSelected());;

		WebElement checkbox2 = this.getDriver().findElement(By.xpath("//input[@type='checkbox'][position()=2]"));
		System.out.println("The second checkbox selection state is " + checkbox2.isSelected());

		return this;
	}

	public CheckboxPage checkFirstChechbox() {

		WebElement checkbox1 = this.getDriver().findElement(By.xpath("//input[@type='checkbox'][position()=1]"));
		checkbox1.click();

		return this;
	}

	public CheckboxPage uncheckSecondCheckbox() {

		WebElement checkbox2 = this.getDriver().findElement(By.xpath("//input[@type='checkbox'][position()=2]"));
		checkbox2.click();

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/checkboxes";
	}

}
