package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CheckBoxesPage;

public class CheckBoxTest  extends TestBaseAssignment{
	
	@Test
	@Parameters({"CheckBoxesUrl"})
	public void CheckBoxFirstIsUncheckedSecondIsCheckedTestCase(String CheckBoxesUrl) throws InterruptedException{
		this.helper.getDriver().get(CheckBoxesUrl);
		this.helper.maximizeWindows();
		
		CheckBoxesPage cp = new CheckBoxesPage(this.helper.getDriver());
		
		
		cp.CheckBoxFirstIsUnchecked();		
		cp.CheckBoxSecondIsSelected();
	}
	
	@Test
	@Parameters({"CheckBoxesUrl"})
	public void CheckBoxFirstIsCheckedSecondIsUnCheckedTestCase(String CheckBoxesUrl) throws InterruptedException{
		this.helper.getDriver().get(CheckBoxesUrl);
		this.helper.maximizeWindows();
		
		CheckBoxesPage cp = new CheckBoxesPage(this.helper.getDriver());
		
		cp.CheckCheckbox("CheckBox 1");
		cp.CheckBoxFirstIsSelected();
		
		cp.CheckCheckbox("CheckBox 2");
		cp.CheckBoxSecondIsUnchecked();
	}
	

}
