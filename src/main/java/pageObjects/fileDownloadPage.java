package pageObjects;

import java.io.File;

import org.openqa.selenium.By;
import utils.Baseclass;

public class fileDownloadPage 
{
	Baseclass bs;
	private final By downloadLink = By.cssSelector("#content div.example a");
	
	public fileDownloadPage(Baseclass bs)
	{
		this.bs = bs;
	}
	
	public void downloadFile()
	{
		bs.sleep(2);
		bs.click(downloadLink); 
		bs.sleep(20);
		bs.takeScreenshot();
	}
	
	public boolean verifyFileDownload()
	{
		String userHomeDir = System.getProperty("user.home");
		userHomeDir = userHomeDir + "/Downloads/";
		File userHomeDirFileObj = new File(userHomeDir);
		File[] list = userHomeDirFileObj.listFiles();
		boolean availability = true;

		for (File file : list) {
			if (file.isFile()) {
				String fileName = file.getName();
				if (fileName.contains("some-file")) {
					availability = true;
				}
			}
		}
		return availability;
	}
	
}
