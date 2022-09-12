package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Page;
import pages.actions.DynamicContentPage;

public class DynamicContentTest {
	
	@Test
	public void DynamicContentRefreshPage() {
		Page.initConfiguration("dynamic_content");
		DynamicContentPage dyp = new DynamicContentPage();
		
		dyp.refreshPage();
		String beforeRefresh = dyp.ContentText();
		dyp.refreshPage();
		String afterRefresh1 = dyp.ContentText();
		dyp.refreshPage();
		String afterRefresh2 = dyp.ContentText();
		SoftAssert softAssert = new SoftAssert();
		System.out.println("before refresh: " +beforeRefresh);
		System.out.println("after one refresh: "+ afterRefresh1);
		System.out.println("after second refresh: "+ afterRefresh2);
		
		
		softAssert.assertFalse(beforeRefresh.equalsIgnoreCase(afterRefresh1), "Content after 1st refresh is not same - Assert Passed");
		softAssert.assertFalse(beforeRefresh.equalsIgnoreCase(afterRefresh2), "Content after 2nd refresh is not same - Assert Passed");
	
		softAssert.assertAll();
		Page.quitBrowser();
	}

}
