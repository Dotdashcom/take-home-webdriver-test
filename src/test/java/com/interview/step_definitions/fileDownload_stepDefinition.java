package com.interview.step_definitions;

import com.interview.pages.FileDownloaderPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.File;


public class fileDownload_stepDefinition {
    FileDownloaderPage fileDownloaderPage=new FileDownloaderPage();
    private static String downloadPath = "/Users/minibae/Downloads";
    @Given("user is on the file download page")
    public void user_is_on_the_file_download_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/download");
    }




    @When("user click the some-file.txt")
    public void user_click_the_some_file_txt() {
fileDownloaderPage.downloadButton.click();
    }
    @Then("it is downloaded")
    public void it_is_downloaded() {
       Assert.assertTrue(isFileDownloaded(downloadPath, "some-file.txt"));
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag=true;
        }

        return flag;
    }




}
