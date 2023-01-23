package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Base_Page;

public class upload_page extends Base_Page {
    WebDriver driver;

    public upload_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"file-upload\"]")
    WebElement file_upload;

    @FindBy(how = How.XPATH, using = "//*[@id=\"file-submit\"]")
    WebElement uplaod_button;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/h3")
    WebElement uploading_confirmation;
    @FindBy(how = How.XPATH, using = "//*[@id=\"uploaded-files\"]")
    WebElement uploading_same_file;

    public void File_Upload_meth() throws InterruptedException {
        file_upload.sendKeys("C:\\Users\\ADMIN\\IdeaProjects\\QA_exercise\\test_data\\FOR_UPLOAD.PNG");
        Thread.sleep(2000);
        uplaod_button.click();
        String uploading_confirmation_actual = uploading_confirmation.getText();
        String uploaded_confirmation_expected = "File Uploaded!";
        String uploading_same_file_actual = uploading_same_file.getText();
        String uploading_same_file_expected = "FOR_UPLOAD.PNG";
        check_String(uploading_confirmation_actual, uploaded_confirmation_expected, "didn't uploaded");
        check_String(uploading_same_file_actual, uploading_same_file_expected, "didn't uploaded");
    }
}

