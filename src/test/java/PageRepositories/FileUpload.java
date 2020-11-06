package PageRepositories;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUpload extends PageUtils {

    public WebDriver driver;

    //Constructor
    public FileUpload(WebDriver driver) {
        this.driver = driver;
    }

    //********************************
    //**********File Uploader*******
    //********************************
    //
    //******File Uploader Elements*****

    String upload_url_path = "/upload";
    String header_upload_page = "//h3";
    String header_upload_page_text = "File Uploader";
    String choose_file = "//div[contains(@id,'drag-drop-upload')]";
    String button_upload = "//input[contains(@id,'file-submit')]";
    String file_name = "some-file.txt";
    String file_upload = "//span[contains(text(),'" + file_name + "')]";

    //*****File Uploader Page Methods****
    @Step("Navigate to File Uploader Page")
    public void navigate_to_upload_page(String base_url) {
        driver.get(base_url + upload_url_path);
        wait_for_element_present(driver, header_upload_page);
    }

    @Step("Validate the File Uploader Page Header is Present")
    public void validate_upload_page_header() {
        verify_text_present(driver, header_upload_page,header_upload_page_text, "File Uploader Page Header Is Not Matched.");
    }

    @Step("Upload File from Download Folder")
    public void upload_file_from_download_folder(String dir_path) throws AWTException{
        String file_path = dir_path + File.separator + file_name;

        wait_for_element_present(driver,choose_file);
        click_element(driver,choose_file);
        custom_wait(2000);
        //Copy your file path to the clipboard
        StringSelection stringSelection = new StringSelection(file_path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        //Execute strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Step("Verify that File is Uploaded")
    public void verify_file_is_uploaded(){
        wait_for_element_present(driver,file_upload);
        verify_element_is_present(driver, file_upload);
    }
}