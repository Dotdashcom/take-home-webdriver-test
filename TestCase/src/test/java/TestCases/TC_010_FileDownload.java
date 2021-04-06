package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TC_010_FileDownload extends BaseClass
{
    @Test (priority=10) //Test Case for File_Download
    public void File_Download()
    {
        //Launching Url for File Download
        driver.get(BaseUrl+"download");
        //inspecting Text file Element on the page with name "some-file.txt"

        WebElement fileTxt1=driver.findElement(By.linkText("some-file.txt"));
        //clicking on file to download
        fileTxt1.click();
        //Capturing the file Name and store into a string variable
        String FileName=fileTxt1.getText();
        System.out.println("First File Name :"+FileName);
        //Checking Assertion for Successful File Download
        Assert.assertEquals(FileName,"some-file.txt");
        File file = new File("C:\\Users\\shahi\\Downloads\\some-file.txt");
        if(file.exists()) {
            System.out.println(FileName+" Downloaded Successfully");
        } else {
            System.out.println(FileName+" Not Downloaded");
        }

        //inspecting Text file Element on the page with name "some-file (5).txt"

        WebElement filetxt2=driver.findElement(By.linkText("some-file (5).txt"));
        //clicking on file 2 to download
        filetxt2.click();
        //Capturing the file Name2 and store into a string variable
        FileName=filetxt2.getText();
        System.out.println("Second File Name :"+FileName);
        //Checking Assertion for Successful File Download
        Assert.assertEquals(FileName,"some-file (5).txt");
        file = new File("C:\\Users\\shahi\\Downloads\\some-file (5).txt");
        if(file.exists()) {
            System.out.println(FileName+" Downloaded Successfully");
        } else {
            System.out.println(FileName+" Not Downloaded");
        }
    }
}
