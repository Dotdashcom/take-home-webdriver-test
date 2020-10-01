package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;


public class DynamicControls extends Base {

	Logger logger = Logger.getLogger(Base.class);

	public void dynamic_Control() {

		driver.get(prop.readProperties("dynamicControl_url"));
		logger.info("Title is :" + driver.getTitle());
		assertEquals(driver.getTitle(), "The Internet");

		WebElement rmBtn = driver.findElement(By.xpath(prop.readProperties("removebtn")));
		rmBtn.click();
		WebElement checkBox = driver.findElement(By.xpath(prop.readProperties("checkbox")));
		Assert.assertEquals(true, checkBox.isDisplayed());
		test.log(Status.INFO, "checkBox.isDisplayed !!");
		WebElement chkBoxMsg = driver.findElement(By.xpath(prop.readProperties("chkBoxmessage")));
		lib.explicitWait(chkBoxMsg);

		String expectedDisappearsMessage = "It's gone!";
		lib.waitForStaleElement(chkBoxMsg);
		Assert.assertEquals(expectedDisappearsMessage, chkBoxMsg.getText());
		test.log(Status.INFO, "It's gone! Assertion Success!!");
		rmBtn.click();

		  WebElement checkBox2 = driver.findElement(By.xpath(prop.readProperties("checkbox")));
		 lib.explicitWait(checkBox2);
         //lib.waitForStaleElement(checkBox2);
		Assert.assertEquals(true, checkBox2.isDisplayed());
		test.log(Status.INFO, "checkBox2 isDisplayed Assert Success!!");
		String expectedAppearsMessage = "It's back!";

		WebElement chkBoxMsg2 = driver.findElement(By.xpath(prop.readProperties("chkBoxmessage")));
		lib.waitForStaleElement(chkBoxMsg2);
		Assert.assertEquals(expectedAppearsMessage, chkBoxMsg2.getText());
		test.log(Status.INFO, "It's Back! Assert Success!!");

		WebElement textWindow = driver.findElement(By.xpath(prop.readProperties("textwindow")));
		Assert.assertTrue(!textWindow.isEnabled());
		test.log(Status.INFO, "Text Window OFF Assert Success!!");
		
		WebElement enableButton = driver.findElement(By.xpath(prop.readProperties("enablebutton")));
		enableButton.click();
		WebElement enableMessage = driver.findElement(By.xpath(prop.readProperties("enablemsg")));
		lib.explicitWait(enableMessage);
		String expMessageEnabl = "It's enabled!";
		Assert.assertEquals(expMessageEnabl, enableMessage.getText());
		test.log(Status.INFO, "It's enabled! Assert Success!!");
		
		enableButton.click();

		WebElement enableMessage2 = driver.findElement(By.xpath(prop.readProperties("enablemsg")));
		lib.explicitWait(enableMessage2);
		
		//lib.waitForStaleElement(enableMessage);
		String expMessageDisabled = "It's disabled!";
		Assert.assertEquals(expMessageDisabled, enableMessage2.getText());
		test.log(Status.INFO, "It's disabled! Assert Success!!");
	}
}
