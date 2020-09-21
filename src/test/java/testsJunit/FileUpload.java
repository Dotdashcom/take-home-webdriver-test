package testsJunit;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Driver;

public class FileUpload extends BaseClass  {

    //I am on the File Upload page
    //I use Upload Button or Drag and Drop to upload a file
    //I assert that the file is uploaded

    @Test
    public void i_am_on_the_File_Upload_page() throws InterruptedException {
        Driver.getDriver().get("http://localhost:7080/upload");
        Driver.getDriver().findElement(By.id("file-upload")).sendKeys("/Users/allashevchenko/IdeaProjects/JunitDotDashProject/uploadfile.docx");
        Driver.getDriver().findElement(By.className("button")).click();
        Thread.sleep(2000);
        if(Driver.getDriver().findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed()){
           Assert.assertTrue("Image Uploaded",true);
        }else{
            Assert.assertTrue("Image is not Uploaded",false);
        }


    }
}
