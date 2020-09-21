package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class CheckBoxesPageObj extends Base {

	public CheckBoxesPageObj() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"checkboxes\"]/input[1]")
	private WebElement box1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"checkboxes\"]/input[2]")
	private WebElement box2;

	public void clickBox1() {
		box1.click();
	}

	public void clickBox2() {
		box1.click();
	}

	public boolean Box1Selected() {
		boolean box1Selected = DriverUtility.isSelected(box1);
		return box1Selected;
	}

	public boolean Box2Selected() {
		boolean box1Selected = DriverUtility.isSelected(box1);
		return box1Selected;
	}

}
