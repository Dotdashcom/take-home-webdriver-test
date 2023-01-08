package com.theInternet.qa.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FileDownloadPage  {
 WebDriver driver;
 
 @FindBy(xpath="//*[@id='content']//div/a")
 WebElement download_link;
 public FileDownloadPage(WebDriver driver)
 {
	 this.driver = driver;
		PageFactory.initElements(driver, this);
 }
 public boolean Check_for_Downloaded_file (String File_download_Path, String Downloaded_fileName)
 {
     // This Method Checks whether the passed file name is downloaded or not in the targeted Folder
     File dir = new File(File_download_Path); // Loading File_download_Path to Dir
     File[] dir_contents = dir.listFiles(); // Loading all Files in that Dir to dir_contents

     // Loop that goes through all the available files in dir
     for (int i = 0; i < dir_contents.length; i++)
     {
         // Validating if the current file matches with the Downloaded_fileName
         if (dir_contents[i].getName().equals(Downloaded_fileName))
         {
             // Once We have a Match we are Deleting that file
             // so next time the test is run it will always check whether the file is downloaded once again or not
             //If we Don't delete the File when the Test is Run and file is not downloaded Test will still PAss
             dir_contents[i].delete();
             return true; 
         }
     }
     return false; 
 }
 
 public void VerifyFile_Download()
 {
	 String downLoadPath="C:\\Users\\palet\\Downloads";
	 download_link.click();
	  Assert.assertTrue(Check_for_Downloaded_file(downLoadPath, "some-file.txt"),"Failed to download Expected document");
 }
 
}
