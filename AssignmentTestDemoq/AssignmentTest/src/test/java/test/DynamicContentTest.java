package test;

import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DynamicContentPage;

public class DynamicContentTest extends TestBaseAssignment {

	
	
	@Test
	@Parameters({"DynamicContentUrl"})
	public void RefreshPageAndAssertContentTestCase(String DynamicContentUrl) throws InterruptedException{
		this.helper.getDriver().get(DynamicContentUrl);
		this.helper.maximizeWindows();
		
		DynamicContentPage dc = new DynamicContentPage(this.helper.getDriver());
		
		List<String>list1 = dc.GetListOfPassages();
		
		helper.RefreshPage();
		helper.RefreshPage();
		
		List<String> list2 = dc.GetListOfPassages();
				
	    dc.VerifyIfListsAreEqual(list1, list2);
	}
	
}
