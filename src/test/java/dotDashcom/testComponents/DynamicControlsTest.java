package dotDashcom.testComponents;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import dotDashcom.pageObjects.DynamicControlsPage;
import org.testng.Assert;

public class DynamicControlsTest extends BaseTest{
	DynamicControlsPage dynamicControls;
	
	@Before
	public void setup() throws IOException {
		setup("/dynamic_controls");
		dynamicControls=new DynamicControlsPage(driver);
	}
	
	@Test
	public void checkAddRemoveButton() {
		String removeMessage=dynamicControls.removeCheckbox();
		Assert.assertEquals(removeMessage,"It's gone!");
		
		String addMessage=dynamicControls.addCheckbox();
		Assert.assertEquals(addMessage, "It's back!");
		
	}
	
	@Test
	public void checkEnableDisableButton() {
		String enableMessage=dynamicControls.enableTextBox();
		Assert.assertEquals(enableMessage, "It's enabled!");
		
		String disableMessage=dynamicControls.disableTextBox();
		Assert.assertEquals(disableMessage, "It's disabled!");
	}
}
