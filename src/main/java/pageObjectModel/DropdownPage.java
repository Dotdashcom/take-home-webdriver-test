package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
	private WebDriver driver;

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='dropdown']")
	private WebElement dropDownField;

	public void dropDownSelect(String option) {
		Select select = new Select(dropDownField);
		select.selectByVisibleText(option);
	}

	public String getSelected() {
		Select select = new Select(dropDownField);
		return select.getFirstSelectedOption().getText();
	}
}
