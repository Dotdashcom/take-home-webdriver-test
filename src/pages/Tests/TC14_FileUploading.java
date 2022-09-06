package pages.Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import graphql.Assert;
import pages.Driver;
import pages.FileUpload;

public class TC14_FileUploading extends Driver {

	@Before
	public void setUp() throws Exception {
		Driver.Initialize();
	}

	@After
	public void tearDown() throws Exception {
		Driver.cleanup();
	}

	
	@Test
	public void test() {
		FileUpload.NavigateToUploadPage();
		FileUpload.FileUpload();
		Assert.assertTrue(FileUpload.ValidateFileUpload());
	}

}
