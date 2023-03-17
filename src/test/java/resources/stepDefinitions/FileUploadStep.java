package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.FileUploadPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class FileUploadStep extends BaseClass{

    @Given("User launches the file uploader page")
    public void user_launches_the_fileuploader() {
        BaseClass tb= new BaseClass();
        String addPath="upload";
        tb.setupDownload(addPath);
    }
    @And("User uploads the file")
    public void fileupload() {
        FileUploadPages fu= new FileUploadPages();
        fu.userfileupload();
    }
    @And("User verifies the file is uploaded")
    public void verifyFileUpload() {
        FileUploadPages fu= new FileUploadPages();
        fu.userverifyFileUpload();
    }
}
