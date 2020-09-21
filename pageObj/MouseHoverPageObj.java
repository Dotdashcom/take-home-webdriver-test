package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class MouseHoverPageObj extends Base {

	public MouseHoverPageObj() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"content\\\"]/div/div[1]/img]")
	private WebElement figureOne;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"content\\\"]/div/div[2]/img]")
	private WebElement figureTwo;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"content\\\"]/div/div[3]/img]")
	private WebElement figureThree;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div/h5")
	private WebElement userOne;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div/h5")
	private WebElement userTwo;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[3]/div/h5")
	private WebElement userThree;

	public void HoverfigureOne() {
		Actions action = new Actions(driver);
		action.moveToElement(figureOne).build().perform();

	}

	public void HoverfigureTwo() {
		Actions action = new Actions(driver);
		action.moveToElement(figureOne).build().perform();

	}

	public void HoverfigureThree() {
		Actions action = new Actions(driver);
		action.moveToElement(figureOne).build().perform();

	}

	public boolean userOneDisplayd() {

		if (userOne.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean userTwoDisplayd() {

		if (userTwo.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean userThreeDisplayd() {

		if (userThree.isDisplayed()) {
			return true;
		} else {
			return false;

		}

	}
}
