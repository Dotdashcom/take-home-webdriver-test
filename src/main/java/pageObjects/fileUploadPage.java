package pageObjects;

import java.io.File;

import org.openqa.selenium.By;
import utils.Baseclass;

public class fileUploadPage 
{
	Baseclass bs;
	private final By chooseFile_input = By.xpath("//input[@id='file-upload']");
	private final By button_upload = By.xpath("//input[@id='file-submit']");
	private final By file_Upload_Messsage = By.xpath("//div[@class='example']/h3");
	
	public fileUploadPage(Baseclass bs)
	{
		this.bs = bs;
	}
	
	public void uploadFile(String FilePath)
	{
		File file = new File(FilePath);
		bs.sendKeys(chooseFile_input, file.getAbsolutePath(),false);
		bs.click(button_upload); 
	}
	
	public String getUploadText()
	{
		return bs.getText(file_Upload_Messsage);
	}
	
}
