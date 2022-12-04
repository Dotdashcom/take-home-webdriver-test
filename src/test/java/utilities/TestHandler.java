package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import baseTest.AbstractE2E;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestHandler extends AbstractE2E {

	public static void scrollToElement(WebElement webElement) {
		Actions ac = new Actions(driver);
		ac.scrollToElement(webElement).perform();
		ac.scrollByAmount(0, 300).perform();
	}

	public static void scrollToElement(WebElement webElement, int deltaX, int deltaY) {
		Actions ac = new Actions(driver);
		ac.scrollToElement(webElement).perform();
		ac.scrollByAmount(deltaX,deltaY).perform();
	}

	public static void scrollToElementUsingJS(WebElement webElement) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false);", webElement); // default is true
		je.executeScript("window.scrollBy(0,300)", "");
	}

	public static void scrollToPage() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void clickOnElementJS(WebElement webElement) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", webElement); // default is true

	}

	public static void captureScreenshot() throws IOException {
		File f = new File("./output/screenshots/");
		System.out.println("Folder available:" + f.isDirectory());
		if (!f.isDirectory()) {
			// FileHandler.createDir(new File("screenshot"));
			f.mkdir();
		}
		TakesScreenshot sc = (TakesScreenshot) driver;
		File file = sc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(f + "/" + getTimeStamp() + "_capture.jpg")); // jpg or png

	}

	static String getTimeStamp() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
		String date = sdf.format(d);
		return date;
	}

	public static void waitForElementToBeVisible(WebElement webElement, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void waitForElementToBeVisible(WebElement webElement, long timeoutInMillis) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofMillis(timeoutInMillis))
						.pollingEvery(Duration.ofMillis(50))
								.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	public static void waitForElementToBeClickable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public static void waitForElementToBeClickable(WebElement webElement, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public static void selectCheckBox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public static void unselectCheckBox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public static void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public String getAlertMessage() {
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}

	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
		if (!filePath.exists())
			throw new WebDriverException("File not found: " + filePath.toString());

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		String JS_DROP_FILE = "var target = arguments[0]," + "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2]," + "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;" + "" + "var input = document.createElement('INPUT');"
				+ "input.type = 'file';" + "input.style.display = 'none';" + "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };" + ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;" + "    target.dispatchEvent(evt);" + "  });" + ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);" + "};"
				+ "document.body.appendChild(input);" + "return input;";

		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
	}

	public static void DragAndDropJS(WebElement source, WebElement destination) throws Exception {
		final String java_script =
				"var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
						"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
						"ction(format,data){this.items[format]=data;this.types.append(for" +
						"mat);},getData:function(format){return this.items[format];},clea" +
						"rData:function(format){}};var emit=function(event,target){var ev" +
						"t=document.createEvent('Event');evt.initEvent(event,true,false);" +
						"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
						"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
						"'drop',tgt);emit('dragend',src);";
		((JavascriptExecutor) driver).executeScript(java_script, source, destination);
		Actions actions = new Actions(driver);
		actions.clickAndHold(source).moveToElement(destination).release().build();
		actions.perform();
	}
}
