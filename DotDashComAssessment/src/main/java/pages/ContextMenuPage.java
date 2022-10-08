package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.PageObjectBase;

public class ContextMenuPage extends PageObjectBase{

	public ContextMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}


	public ContextMenuPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public ContextMenuPage rightClickMenu() {

		Actions actions = new Actions(getDriver());
		WebElement menu = this.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

		actions.contextClick(menu).perform();

		return this;
	}

	public String returnAlertMessage() {

		return this.getDriver().switchTo().alert().getText();
	}

	@Override
	protected String getRelativeUrl() {
		return "/context_menu";
	}

}
