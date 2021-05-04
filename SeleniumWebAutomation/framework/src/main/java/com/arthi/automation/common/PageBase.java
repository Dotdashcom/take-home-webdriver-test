package com.arthi.automation.common;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.arthi.automation.reporters.ExtentTestManager;
/**
 * 
 * @author Arthina Kumar
 *
 */
public class PageBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(PageBase.class);
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public PageBase(WebDriver driver) {		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		this.wait.until(d -> ((JavascriptExecutor)d).executeScript("return document.readyState;").toString().equals("complete"));
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	public void waitForElementVisible(WebElement element, int maxWaitTime){
		WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillVisible(WebElement element, final String expectedText) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
	}
	
//	@Deprecated
//	public void waitTillVisible(By elementBy, final String expectedText) {
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(elementBy, expectedText));
//	}
	
	public void waitTillAllVisible(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitTillVisible(WebElement... element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
//	@Deprecated
//	public void waitTillVisible(By elementBy) {
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
//	}
	
	public void submitForm(WebElement element) {
		waitTillVisible(element);
		element.submit();
		ExtentTestManager.logInfo("Submiting the Page...");
	}

//	@Deprecated
//	public void submitForm(By elementBy) {
//		waitTillVisible(elementBy);
//		driver.findElement(elementBy).submit();
//		ExtentTestManager.logInfo("Submit the Form...");
//	}

	public void refreshPage(){
		driver.navigate().refresh();
		this.ensurePageReadyState();
		ExtentTestManager.logInfo("Refreshed the WebPage & Loaded the Elements : "+ getPageTitle());
	}
	
	public void click(WebElement element, final String elementName){
		waitForElementVisible(element, 100);
		if (element.isDisplayed()){
			element.click();
			ExtentTestManager.logInfo("Clicked the element: " + elementName);
			sleep(3000);
		}else{
			ExtentTestManager.logFatal("The element " + elementName + " is Not Visible");
		}
	}
	
//	public void clearAndSendKeys(WebElement element, String textToEnter){
//		waitForElementVisible(element, 100);
//		if (element.isDisplayed()){
//			element.clear();
//			element.sendKeys(textToEnter);
//		}else{
//			ExtentTestManager.logFatal("The element "+element.getText()+" is Not Visible");
//		}
//	}
	
	public void gotoPreviousPage(){
		driver.navigate().back();;
		this.ensurePageReadyState();
		ExtentTestManager.logInfo("Navigated back to the Previous Page : " +getPageTitle());
	}

	public Boolean hasActiveFocus(WebElement webElement){
		return webElement.equals(driver.switchTo().activeElement());
	}
	
	public String getValidationMessage(WebElement webElement){
		return webElement.getAttribute("validationMessage");
	}
	
	public String getPlaceHolderText(WebElement webElement){
		return webElement.getAttribute("placeholder");
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public String getPageURL(){
		return driver.getCurrentUrl();
	}
	
	private void ensurePageReadyState() {
		// TODO Auto-generated method stub
		
	}

	public void waitForElementToBeClickable(WebElement element, int maxWaitTime) {
		WebDriverWait clickElementWait = new WebDriverWait(driver, maxWaitTime);
		clickElementWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@Deprecated
	public void waitForElementToBeClickable(By elementBy, int maxWaitTime) {
		WebDriverWait clickElementWait = new WebDriverWait(driver, maxWaitTime);
		clickElementWait.until(ExpectedConditions.elementToBeClickable(elementBy));
	}

	public void uploadFile(WebElement element, final String filePath) {
//		waitTillVisible(element);
		if (StringUtils.isNotEmpty(filePath)) {
			element.sendKeys(filePath);
			ExtentTestManager.logInfo("Trying to Upload File [" + filePath + "] on element:" + element.toString());
		}
		else {
			ExtentTestManager.logInfo("Skipping File upload as value [" + filePath + "] is EMPTY/NULL for element:" + element.toString());
			LOGGER.debug("Given value: [{}] for Element:{} is NULL/EMPTY" , filePath, element.toString());
		}
	}
	
	public void verifyDropdownValues(WebElement element, String... values) {
		Select givenSelect = new Select(element);
		List<WebElement> options = givenSelect.getOptions();
		
		for (int i=0; i< options.size(); i++) {
			Assert.assertEquals(options.get(i).getText(), values[i]);
		}
	}

	@Deprecated
	public void verifyDropdownValues(By elementBy, String... values) {
		Select givenSelect = new Select(driver.findElement(elementBy));
		List<WebElement> options = givenSelect.getOptions();
		
		for (int i=0; i< options.size(); i++) {
			Assert.assertEquals(options.get(i).getText(), values[i]);
		}
	}
	
	public void setSelectOptionBasedOnDisplayText(WebElement element, final String value) {
		try {
			Select selectOptionDdl = new Select(element);
			if (StringUtils.isNotEmpty(value)) {
				selectOptionDdl.selectByVisibleText(value);
				ExtentTestManager.logInfo("Trying to set the display Text [" + value + "] on Drodpwn element:" + element.toString());
			}
			else {
				ExtentTestManager.logInfo("Skipping Dropdown Select as value [" + value + "] is EMPTY/NULL for element:" + element.toString());
				LOGGER.debug("Given value: [{}] for Element:{} is NULL/EMPTY" , value, element.toString());
			}			
		}
		catch(Exception e) {
			ExtentTestManager.logFail(e.getLocalizedMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}

	@Deprecated
	public void setSelectOptionBasedOnDisplayText(By elementBy, final String value) {
		try {
			Select selectOptionDdl = new Select(driver.findElement(elementBy));
			if (StringUtils.isNotEmpty(value)) {
				selectOptionDdl.selectByVisibleText(value);
				ExtentTestManager.logInfo("Display Text [" + value + "] set on Drodpwn element:" + elementBy.toString());
			}
			else {
				ExtentTestManager.logInfo("Skipping Dropdown Select as value [" + value + "] is EMPTY/NULL for element:" + elementBy.toString());
				LOGGER.debug("Given value: [{}] for Element:{} is NULL/EMPTY" , value, elementBy.toString());
			}			
		}
		catch(Exception e) {
			ExtentTestManager.logFail(e.getLocalizedMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	public void setSelectOptionBasedOnValue(WebElement element, final String value) {
		Select selectOptionDdl = new Select(element);
		selectOptionDdl.selectByValue(value);
	}
	
	public void setSelectOptionBasedOnIndex(WebElement element, int index) {
		Select selectOptionDdl = new Select(element);
		selectOptionDdl.selectByIndex(index);
	}
	
	public void setSelectMultipleOptionsBasedOnDisplayText(WebElement element, final List<String> values) {
		Select selectOptionDdl = new Select(element);
		selectOptionDdl.deselectAll();
		values.stream()
		.filter(value -> {
			if (StringUtils.isNotBlank(value)) {
				return true;
			}
			else {
				LOGGER.debug("Given value: [{}] for Element:{} is NULL/EMPTY" , value, element.toString());
				return false;
			}
		})
		.forEach(value -> selectOptionDdl.selectByVisibleText(value));
	}
	


	
	/**
	 * Method used to set the Text on TextBox field as well as FileUpload(input type=file)
	 * @param elementBy
	 * @param text
	 */
	public void writeText(WebElement element, final String text) {
		waitForElementVisible(element, 10);
		//waitTillVisible(element);
		if (StringUtils.isNotEmpty(text)) {
			if (element.isDisplayed()) {
				element.clear();
				element.sendKeys(StringUtils.trim(text));
		        ExtentTestManager.logInfo("Writing value [" + StringUtils.trim(text) + "] on element:" + element.toString() + " as " + element.getText());
			}
			else {
				ExtentTestManager.logFatal("The element " + element.toString() + " is Not Visible");
			}
		}
		else {
			ExtentTestManager.logDebug("Skip NULL/EMPTY value to write on element:" + element.toString());
		}
	}

	/**
	 * Method to get the Text from the Field
	 * @param elementBy
	 * @return
	 */
	public void clearText(WebElement element) {
		waitTillVisible(element);
		element.clear();
	}
	
	/**
	 * Method to get the Text from the Field
	 * @param elementBy
	 * @return
	 */
	public String readText(WebElement element) {
		waitTillVisible(element);
		return element.getText();
	}
	
	public String getPlaceholderText(WebElement element) {
		return element.getAttribute("placeholder");
	}
	
	/**
	 * Method to set the dropdown based on the display value
	 * @param elementBy
	 * @param displayText
	 */
	public void selectDropdown(WebElement element, final String displayText) {
		waitTillVisible(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(displayText);
	}

	public String getSelectedValue(WebElement element) {
		waitTillVisible(element);
		Select dropdown = new Select(element);		
		return dropdown.getAllSelectedOptions().stream().map(option -> option.getText()).collect(Collectors.joining(","));
	}

	public void verifyPageTitle(final String expectedText) {
		wait.until(ExpectedConditions.titleContains(expectedText));
	}

	public void assertEquals(WebElement element, final String expectedText) {
		final String actualText = readText(element);
		ExtentTestManager.logInfo("Validating the Actual: " + actualText + " equals Expected: " + expectedText + " for the element: " + element.toString());
		Assert.assertEquals(actualText, expectedText);
	}

	public void assertContains(WebElement element, final String expectedText) {
		final String actualText = readText(element);
		ExtentTestManager.logInfo("Validating the Actual: " + actualText + " conatins Expected: " + expectedText + " for teh element: " + element.toString());
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	public void assertLists(List<WebElement> elements, final List<String> expectedList) {
		waitTillAllVisible(elements);
		for(int i=0; i < expectedList.size(); i++) {
			assertEquals(elements.get(i), expectedList.get(i));
		}
	}
	
	public void assertMultiple(final List<String> expectedList, WebElement... elements) {
		waitTillVisible(elements);
		for(int i=0; i < elements.length; i++) {
			Assert.assertEquals(elements[i].getText(), expectedList.get(i));
		}
	}

	protected void sleep(long timeInMillis) {
		try {
			TimeUnit.MILLISECONDS.sleep(timeInMillis);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}