package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.FileUploadPage;
import task.utilities.Driver;
import java.io.File;

public class FileUpload {


    FileUploadPage fileUploadPage = new FileUploadPage();

    String actualUploadFileName;
    String expectedUploadFileName = "some-file.txt";


    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/upload");
    }



    @Test
    public void testFileUpload(){

        fileUploadPage.uploadFile(expectedUploadFileName);

        actualUploadFileName = fileUploadPage.uploadedFiles.getText();

        Assertions.assertEquals(expectedUploadFileName, actualUploadFileName);


    }


    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }

}
