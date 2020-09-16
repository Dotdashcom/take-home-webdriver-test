package com.automation.steps;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.File;

public class File_Download_Upload_Steps {
    @When("I click on file {string} filename")
    public void i_click_on_file_filename(String fileName) {
        Driver.get().findElement(By.linkText(fileName)).click();
        BrowserUtils.wait(2000);
    }

    @Then("{string} is downloaded to specified path")
    public void is_downloaded_to_specified_path(String nameOfFile) {
        File folder = new File(System.getProperty("user.dir")+"/target/downloads");
        //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;

        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if(fileName.matches(nameOfFile)) {
                    found = true;
                }
            }
        }
        Assert.assertTrue(found);
    }

    @When("I select {string} from temp folder to upload")
    public void i_select_a_file_from_temp_folder_to_upload(String fileName) {
        Driver.get().findElement(By.id("file-upload"))
                .sendKeys(System.getProperty("user.dir")+"/target/downloads/"+fileName);
        Driver.get().findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("verify that {string} is displayed after uploading")
    public void verify_that_is_displayed_after_uploading(String fileName) {
        String uploadedFileName = Driver.get().findElement(By.id("uploaded-files")).getText();
        System.out.println(uploadedFileName);
        Assert.assertEquals(fileName, uploadedFileName);
    }

}

