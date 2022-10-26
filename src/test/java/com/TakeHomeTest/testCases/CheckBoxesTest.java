package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.CheckBoxPageObjects;

public class CheckBoxesTest extends BaseClass {


	boolean checkisSelected;
	boolean checkisnotSelected;

	int size;
	
	@Test
	public void checks_test() {
		CheckBoxPageObjects pageobj=new CheckBoxPageObjects(driver);

		driver.get(url+"/checkboxes");
		
		size=pageobj.checkboxes.size();

		for(int i=0;i<size;i++) {
			checkisSelected=pageobj.checkboxes.get(i).isSelected();
				if(checkisSelected==true) {
				Assert.assertTrue(checkisSelected);
			}
				else {
					pageobj.checkboxes.get(i).click();
				}
						}	
	}
	@Test
	public void unchecks_test() {
		CheckBoxPageObjects pageobj=new CheckBoxPageObjects(driver);
		driver.get("http://localhost:7080/checkboxes");
		
		size=pageobj.checkboxes.size();

		for(int i=0;i<size;i++) {
			checkisnotSelected=pageobj.checkboxes.get(i).isSelected();
				if(checkisnotSelected==false) {
				Assert.assertFalse(checkisnotSelected);
			}
				else {
					pageobj.checkboxes.get(i).click();
				}
		}	
}
}