package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.FileDownloadPage;
import task.utilities.Driver;

import java.io.File;

public class FileDownload {



    FileDownloadPage fileDownloadPage = new FileDownloadPage();



    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/download");
    }



    @Test
    public void testFileDownload(){

        fileDownloadPage.downloadFile();

        String fileName = fileDownloadPage.file.getText();

        //to make it OS independent, System.getProperty() and File.separator
        String downloadsDir = System.getProperty("user.home") + File.separator + "Downloads" + File.separator;
        File fileDownloaded  = new File(downloadsDir + fileName);


        Assertions.assertTrue(fileDownloaded.exists());



    }



    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }
}
