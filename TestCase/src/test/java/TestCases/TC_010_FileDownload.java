package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        String Filetxt=fileTxt1.getText();
        System.out.println("First File Name :"+Filetxt);
        //Checking Asserrtion for Succeful File Download
        Assert.assertEquals(Filetxt,"some-file.txt");
        System.out.println(Filetxt+" Downloaded Successfully");
        //inspecting Text file Element on the page with name "some-file (5).txt"

        WebElement filetxt2=driver.findElement(By.linkText("some-file (5).txt"));
        //clicking on file 2 to download
        filetxt2.click();
        //Capturing the file Name2 and store into a string variable
        String FileTxt2=filetxt2.getText();
        System.out.println("Second File Name :"+FileTxt2);
        //Checking Asserrtion for Succeful File Download
        Assert.assertEquals(FileTxt2,"some-file (5).txt");
        System.out.println(FileTxt2+" Downloaded Successfully");
    }
}
