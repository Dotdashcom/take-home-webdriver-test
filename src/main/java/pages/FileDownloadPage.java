package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.rmi.Remote;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class FileDownloadPage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public FileDownloadPage(WebDriver driver,SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert=softAssert;

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='download/some-file.txt']")
    private WebElement downLoadLink;

    public void downLoadFile() throws InterruptedException {


        navigateToDownloadPage();
        downLoadLink.click();
        Thread.sleep(3000);

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        downLoadLink.click();
//        Thread.sleep(5000);
//        File folder = new File(System.getProperty("user.marynagrabchuk"));
////List the files on that folder
//        File[] listOfFiles = folder.listFiles();
//        boolean found = false;
//        File f = null;
//        //Look for the file in the files
//        // You should write smart REGEX according to the filename
//        for (File listOfFile : listOfFiles) {
//            if (listOfFile.isFile()) {
//                String fileName = listOfFile.getName();
//                System.out.println("File " + listOfFile.getName());
//                if (fileName.matches("some-file.txt")) {
//                    f = new File(fileName);
//                    found = true;
//                }
//            }
//        }
//        softAssert.assertTrue(found, "Downloaded document is not found");
//       // f.deleteOnExit();






        String folderName = System.getProperty("users/marynagrabchuk") + File.separator + "downloads";

        // Array to Store List of Files in Directory
        File[] listOfFiles;

        // Store File Name
        String fileName;

        //  Consider file is not downloaded
        boolean fileDownloaded = false;

        // capture time before looking for files in directory
        // last modified time of previous files will always less than start time
        // this is basically to ignore previous downloaded files
        long startTime = Instant.now().toEpochMilli();

        // Time to wait for download to finish
        long waitTime = startTime ;

        // while current time is less than wait time
        while (Instant.now().toEpochMilli() < waitTime)
        {
            // get all the files of the folder
            listOfFiles = new File(folderName).listFiles();

            // iterate through each file
            for (File file : listOfFiles)
            {
                // get the name of the current file
                fileName = file.getName().toLowerCase();

                // condition 1 - Last Modified Time > Start Time
                // condition 2 - till the time file is completely downloaded extension will be crdownload
                // Condition 3 - Current File name contains expected Text
                // Condition 4 - Current File name contains expected extension
                if (file.lastModified() > startTime && !fileName.contains("crdownload") &&   fileName.contains("some-file".toLowerCase()) && fileName.contains("txt".toLowerCase()))
                {
                    // File Found
                    fileDownloaded = true;
                    break;
                }
            }
            // File Found Break While Loop
            if (fileDownloaded)
                break;
        }
        // File Not Found
        System.out.println(fileDownloaded);
    }

    private void navigateToDownloadPage(){
        driver.get(ConfigReader.getProperty("url")+"/download");
    }

}
