package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.PageObjectBase;

public class DropdownPage extends PageObjectBase {

	public DropdownPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DropdownPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public String selectOption(String text) {

		WebElement dropdownList = this.getDriver().findElement(By.xpath("//select[@id='dropdown']"));

		Select selectDropdown = new Select(dropdownList);
		selectDropdown.selectByVisibleText(text);

		String option = selectDropdown.getFirstSelectedOption().getText();
		System.out.println(option);

		return option;

	}

	@Override
	protected String getRelativeUrl() {
		return "/dropdown";
	}

}
