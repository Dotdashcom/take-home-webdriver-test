package pages;

import common.POBase;
import utils.BrowserUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Path;

public class FilesOperations extends POBase {
    public void verifyFileDownload(){
        String fileName = "some-file.txt";
        // Update the path below as needed:
        String filePath = "C:\\Users\\${user}\\Downloads\\";
        File dir = new File(filePath);
        File[] dirContents = dir.listFiles();
        // Delete file/s exist:
        for (File file:dirContents) {
            if(file.getName().equals(fileName)){
                FileUtils.deleteQuietly(new File(filePath + fileName));
            }
        }
        getElement(By.linkText(fileName)).click();
        boolean success = false;
        for (File file:dirContents) {
            if(file.getName().equals(fileName)){
                success = true;
                break;
            }
        }
        Assert.assertTrue(success);
    }

    // Tried with System property...isn't working consistently...need to spend more time.
    public void verifyFileDownload2(){
        String fileName = "some-file.txt";
        //getElement(By.linkText(fileName + ".txt")).click();
        String home = System.getProperty("user.home");
        //String fileWithPath = home + "\\Downloads\\" + fileName;
        String fileWithPath = home + "\\Downloads\\";
        File dir = new File(fileWithPath);
        File[] dir_contents = dir.listFiles();
        Assert.assertTrue(dir_contents[0].getName().equals(fileName));
        //Assert.assertTrue(file.exists());
    }

    public void verifyFileUpload(){
        WebElement browse = BrowserUtil.GetDriver().findElement(By.xpath("//input[@id='file-upload']"));
        //browse.sendKeys("C:\\Users\\${user}\\Downloads\\some-file.txt");
        //browse.sendKeys("C:\\Projects\\IdeaProjects\\Dotdash\\src\\test\\java\\resources\\some-file.txt");
        String path = Path.of("").toAbsolutePath().toString();
        String fileWithPath = path + "\\src\\test\\java\\resources\\some-file.txt";
        browse.sendKeys(fileWithPath);
        System.out.println("File uploaded!");
        getElement(By.id("file-submit")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//h3[text()='File Uploaded!']")));
    }
}
