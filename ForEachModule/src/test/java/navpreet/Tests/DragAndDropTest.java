package navpreet.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.DragAndDropPageObject;
import navpreet.util.ObjectsOfClasses;


public class DragAndDropTest extends ObjectsOfClasses{

	ObjectsOfClasses base_instance;
	DragAndDropPageObject ddpo;
	
	@Test(description="Test drags element A to element B.Test asserts that the text on element A and B are switched.")
	public void DragAndDrop() throws IOException
	{
		ddpo=dragAndDropApplication();
		ddpo.ClickDragAndDrop();
		String beforeDragSrc=ddpo.GetSourceText();
		String beforeDragDest=ddpo.GetDestinationText();
		ddpo.DragAndDrop();
		ddpo.ImplicitlyWait();
		String afterDragSrc=ddpo.GetSourceTextAfter();
		String afterDragDest=ddpo.GetDestinationTextAfter();
		Assert.assertEquals(beforeDragSrc, afterDragDest);
		Assert.assertEquals(beforeDragDest, afterDragSrc);
	}
}
