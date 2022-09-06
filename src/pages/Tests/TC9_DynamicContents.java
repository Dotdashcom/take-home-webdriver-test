package pages.Tests;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import pages.Driver;
import pages.DynamicContent;


public class TC9_DynamicContents extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	

	@Test
	public void ValidateTextAfterRefresh1() {
		
		DynamicContent.NavigateToDynamicContentPage();
		String Text1 = DynamicContent.GetText();
		DynamicContent.RefreshPage();
		String Text2 = DynamicContent.GetText();
		Assert.assertNotEquals(Text1,Text2);
		
	}
	
	@Test
	public void ValidateTextAfterRefresh2() {
		
		DynamicContent.NavigateToDynamicContentPage();
		DynamicContent.RefreshPage();
		String Text2 = DynamicContent.GetText();
		DynamicContent.RefreshPage();
		String Text3 = DynamicContent.GetText();
		Assert.assertNotEquals(Text2,Text3);
		
	}
	
	
	@Test
	public void ValidateImageAfterRefresh1() {
		
		DynamicContent.NavigateToDynamicContentPage();
		String Text1 = DynamicContent.GetAttribute();
		DynamicContent.RefreshPage();
		String Text2 = DynamicContent.GetAttribute();
		Assert.assertNotEquals(Text1,Text2);
		
	}
	
	
	@Test
	public void ValidateImageAfterRefresh2() {
		
		DynamicContent.NavigateToDynamicContentPage();
		DynamicContent.RefreshPage();
		String Text2 = DynamicContent.GetAttribute();
		DynamicContent.RefreshPage();
		String Text3 = DynamicContent.GetAttribute();
		Assert.assertNotEquals(Text2,Text3);
		
	}
	
	@Test
	public void ValidateImageAndTextAfterRefresh() {
		
		DynamicContent.NavigateToDynamicContentPage();
		String Text1 = DynamicContent.GetText();
		String image1 = DynamicContent.GetAttribute();
		DynamicContent.RefreshPage();
		String Text2 = DynamicContent.GetText();
		String image2 = DynamicContent.GetAttribute();
		Assert.assertNotEquals(Text1,Text2);
		Assert.assertNotEquals(image1,image2);
		
	}
	
	
	@AfterClass
	public static void tearDown() throws Exception {
		Driver.cleanup();
	}

}
