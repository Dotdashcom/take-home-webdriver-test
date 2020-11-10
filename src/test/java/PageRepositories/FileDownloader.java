package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class FileDownloader extends PageUtils {

    public WebDriver driver;

    //Constructor
    public FileDownloader(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //**********File Downloader*******
    //********************************
    //
    //******File Downloader Elements*****

    String download_url_path = "/download";
    String header_download_page = "//h3";
    String header_download_page_text = "File Downloader";
    String file_download = "//a[contains(.,'some-file')]";
    String file_name = "some-file.txt";

    //*****File Downloader Page Methods****
    @Step("Navigate to File Downloader Page")
    public void navigate_to_download_page(String base_url) {
        driver.get(base_url + download_url_path);
        wait_for_element_present(driver, header_download_page);
    }

    @Step("Validate the File Downloader Page Header is Present")
    public void validate_download_page_header() {
        verify_text_present(driver, header_download_page,header_download_page_text, "File Downloader Page Header Is Not Matched.");
    }

    @Step("Click File Download Link in the Downloader Page")
    public void click_file_link_to_download() {
        click_element(driver,file_download);
    }

    @Step("Download File Exists")
    public void download_file_exists() {
        Assert.assertTrue(true);
    }

    @Step("Download File Does Not Exist")
    public void download_file_does_not_exist() {
        Assert.assertTrue(false);
    }

    @Step("Check the Download File in the Download Folder")
    public void check_download_file_in_the_download_folder(String dir_path) {
        //There will be only one file of a specific name to ensure that the downloaded file exists
        //The FileDownloader Tests clean the Download folder before running this method
        String file_path = dir_path + File.separator + file_name;
        if (new File(file_path).exists()) { download_file_exists();}
        else {download_file_does_not_exist();}
    }

}