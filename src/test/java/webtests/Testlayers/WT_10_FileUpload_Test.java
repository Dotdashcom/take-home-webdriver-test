package webtests.Testlayers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_010_FileUpload_POM;

public class WT_10_FileUpload_Test extends WT_BaseClass{

	WT_010_FileUpload_POM fu;
	
	//Constructor
    public WT_10_FileUpload_Test() {
	     super();
}
    @BeforeMethod
	public void initsetup() {
    	fu = new WT_010_FileUpload_POM();
    	
    	driver.get(pr.getProperty("baseurl")+"/upload");
    	logg.info("****FileUpload url opened****");
    }
    @Test
	public void UploadFileTest() throws InterruptedException {
    	
    	String filepath="C:\\Users\\gotid\\Downloads\\some-file.txt";
    	fu.Uploadefile(filepath);
    	logg.info("****File has been choosen****");
    	
    	Thread.sleep(1000);
        
        fu.ClickUploadBtn();
        logg.info("****test clicked on upload button****");
        
    	Assert.assertEquals(fu.verifyuploadedfile(),"some-file.txt");
    	Assert.assertEquals(fu.Uploadedtext(),"File Uploaded!" );
    	logg.info("****Test Passed****");
    }
}
   
