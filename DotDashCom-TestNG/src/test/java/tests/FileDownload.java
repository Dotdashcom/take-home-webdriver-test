package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
import utilities.ConfigReader;
import utilities.Driver;

public class FileDownload {
    FileDownloadPage fileDownloadPage = new FileDownloadPage();
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"download");
        String downloadFile = fileDownloadPage.file.getText();
        fileDownloadPage.file.click();
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/"+downloadFile;
        String filePath = projectPath+"/"+relativePath;
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
