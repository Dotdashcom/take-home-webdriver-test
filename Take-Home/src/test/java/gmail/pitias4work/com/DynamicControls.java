package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.pitias.Base;

public class DynamicControls extends Base {

	Logger logger = Logger.getLogger(Base.class);

	public void dynamic_Control() {

		driver.get("http://localhost:7080/dynamic_controls");
		logger.info("Title is :" + driver.getTitle());
		assertEquals(driver.getTitle(), "The Internet");

		WebElement rmBtn = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
		rmBtn.click();
		WebElement checkBox = driver.findElement(By.xpath("//*[@type='checkbox']"));
		Assert.assertEquals(true, checkBox.isDisplayed());
		WebElement chkBoxMsg = driver.findElement(By.xpath("//*[@id='message']"));
		lib.explicitWait(chkBoxMsg);

		String expectedDisappearsMessage = "It's gone!";
		WebElement checkBoxMessage1 = driver.findElement(By.xpath("//*[@id='message']"));
		Assert.assertEquals(expectedDisappearsMessage, checkBoxMessage1.getText());
		rmBtn.click();

		WebElement checkBox2 = driver.findElement(By.xpath("//*[@type='checkbox']"));
		lib.explicitWait(checkBox2);

		Assert.assertEquals(true, checkBox2.isDisplayed());
		String expectedAppearsMessage = "It's back!";

		WebElement chkBx2 = driver.findElement(By.xpath("//*[@id='message']"));
		Assert.assertEquals(expectedAppearsMessage, chkBx2.getText());

		WebElement textWindow = driver.findElement(By.xpath("//*[@type='text']"));
		Assert.assertTrue(!textWindow.isEnabled());
		WebElement enableButton = driver.findElement(By.xpath("//*[@onclick='swapInput()']"));
		enableButton.click();

		WebElement enableMessage = driver.findElement(By.xpath("//p[@id='message']"));
		lib.explicitWait(enableMessage);
		String expMessageEnabl = "It's enabled!";
		Assert.assertEquals(expMessageEnabl, enableMessage.getText());
		enableButton.click();

		WebElement enableMessage2 = driver.findElement(By.xpath("//p[@id='message']"));
		lib.explicitWait(enableMessage2);
		String expMessageDisabled = "It's disabled!";
		Assert.assertEquals(expMessageDisabled, enableMessage2.getText());
	}
}
