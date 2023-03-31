package dotDashcom.testComponents;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import dotDashcom.pageObjects.CheckBoxPage;


public class CheckBoxTest extends BaseTest {

	CheckBoxPage checkBoxPage;

	@Before
	public void setup() throws IOException {
		setup("/checkboxes");
		checkBoxPage = new CheckBoxPage(driver);

	}
	
	@Test
	public void selectCheckBox() {
		
		//selecting and unselecting the CheckBox 1 
		Assert.assertFalse(checkBoxPage.getCheckBox1().isSelected());
		checkBoxPage.getCheckBox1().click();
		System.out.println("CheckBox 1 is selected");
		Assert.assertTrue(checkBoxPage.getCheckBox1().isSelected());
		
		
		//unselecting and selecting the CheckBox 2 
		Assert.assertTrue(checkBoxPage.getCheckBox2().isSelected());
		checkBoxPage.getCheckBox2().click();
		System.out.println("CheckBox 2 is unselected");
		Assert.assertFalse(checkBoxPage.getCheckBox2().isSelected());
		
		
	}
	
}
