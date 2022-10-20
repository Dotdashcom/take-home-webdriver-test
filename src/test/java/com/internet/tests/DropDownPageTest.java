package com.internet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.BaseClass;
import com.internet.pages.DragAndDropPage;
import com.internet.pages.DropDownPage;
import com.internet.pages.InternetPage;
import com.internet.utils.Utils;

public class DropDownPageTest extends BaseClass {
	InternetPage internet;
	DropDownPage dropDown;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);

		dropDown = internet.clickDropDown();

	}

	@Test
	public void selectOption1Test() {
		dropDown.selectOption1();
		Assert.assertEquals(dropDown.getSelectedOptions(), "Option 1");
	}

	@Test
	public void selectOption2Test() {
		dropDown.selectOption2();

		Assert.assertEquals(dropDown.getSelectedOptions(), "Option 2");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}