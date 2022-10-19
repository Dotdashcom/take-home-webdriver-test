package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class DragandDrop extends BaseTest {

	public DragandDrop() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="column-a")
	private static WebElement A;
	
	@FindBy(id="column-b")
	private static WebElement B;
	
	public Actions DragandDropA() {
		action = new Actions(driver);
		action.dragAndDrop(A, B).build().perform();
		Actions a = action.moveToElement(A);
		return a;
	}
	
	public Actions DragandDropB() {
		action = new Actions(driver);
		action.dragAndDrop(B, A).build().perform();
		Actions b = action.moveToElement(B);
		return b;
	}
	
	
	public void DragandDropAssertion() {
		 
		if (A.getText().toString() != B.getText().toString()) {
			new DragandDrop();
		Assert.assertNotEquals(A, B);
	}
		else {
			new DragandDrop();
			Assert.assertNotEquals(B, A);
		}
	}
}