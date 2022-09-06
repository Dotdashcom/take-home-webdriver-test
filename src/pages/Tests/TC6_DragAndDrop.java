package pages.Tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.Driver;
import pages.DragAndDrop;

public class TC6_DragAndDrop {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}
	
	@Test
	public void ValidateDragAndDrop() {
		DragAndDrop.NavigateToDrageDropPage();
		DragAndDrop.DragAndDropFromAtoBColumn();
		Assert.assertTrue(DragAndDrop.ValidateColumnBHeader().contains("A"));
	}

}
