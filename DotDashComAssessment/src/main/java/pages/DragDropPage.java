package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.PageObjectBase;

public class DragDropPage extends PageObjectBase{

	public DragDropPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DragDropPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public DragDropPage currentLocation() {

		WebElement leftColumn = this.getDriver().findElement(By.xpath("//div[@id='column-a']"));
		System.out.println("The left column contains box "+ leftColumn.getText());

		WebElement rightColumn = this.getDriver().findElement(By.xpath("//div[@id='column-b']"));
		System.out.println("The right column contains box "+ rightColumn.getText());

		return this;
	}

	public DragDropPage moveBoxA() {

		WebElement leftColumn = this.getDriver().findElement(By.xpath("//div[@id='column-a']"));
		WebElement rightColumn = this.getDriver().findElement(By.xpath("//div[@id='column-b']"));


		/*Actions builder = new Actions(getDriver());

		Action dragAndDrop = builder.clickAndHold(leftColumn)
				.moveToElement(rightColumn)
				.release(rightColumn)
				.build();

		dragAndDrop.perform();*/

		Actions action = new Actions(getDriver());
		action.dragAndDrop(leftColumn, rightColumn).build().perform();

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/drag_and_drop";
	}

}
