package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.DropDownPage;

public class DropDownPageTest extends TestBase{
	
	DropDownPage dropDownPage;
	
	
	@BeforeMethod
	public void setup(){
		initialization("/dropdown");
		dropDownPage = new DropDownPage();
	}
	
	@Test(priority = 1)
	public void loginSuccessTest() {
		dropDownPage.selectValue();
	}


}
