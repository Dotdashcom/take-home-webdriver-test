package Test_Cases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.DragAndDropPage;

import TestBase.BaseTest;
public class dragAndDropPageTest extends BaseTest {
	DragAndDropPage dragAndDrop;

	public dragAndDropPageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		dragAndDrop = new DragAndDropPage();
	}

	@Test
	public void dragAndDropTest() {
		//Log.info("Trying to logging into the application.");
		// logging into application
		dragAndDrop.getUrl();
		String elementATextBefore = dragAndDrop.getSourceText();
		System.out.println(elementATextBefore);
		//String elementATextExpected = "A";
		String elementBTextBefore = dragAndDrop.getTargetText();
		System.out.println(elementBTextBefore);
		//String elementBTextExpected = "B";
		//verifying the text before the drag and drop
		//Assert.assertTrue(elementATextBefore.equalsIgnoreCase(elementATextExpected));
		//drag and drop the element
		dragAndDrop.dragAndDrop();
		//verifying the text before the drag and drop
		String elementATextAfter = dragAndDrop.getSourceText();
		System.out.println(elementATextAfter);
		String elementBTextAfter = dragAndDrop.getTargetText();
		System.out.println(elementBTextAfter);
		//Assert.assertTrue(elementATextAfter.equalsIgnoreCase(elementBTextExpected));


	}

}
