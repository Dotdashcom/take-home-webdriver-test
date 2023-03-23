package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadPage {

    private SelenideElement inputChooseFile = $("#file-upload");
    private SelenideElement buttonUpload = $("#file-submit");
    private SelenideElement formFileUploaded= $("#uploaded-files");


    @Step("ChooseFile")
    public void chooseFile(String filePath){
        this.inputChooseFile.uploadFile(new File(filePath));
    }

    @Step("UploadFile")
    public void uploadFile(){
        this.buttonUpload.click();
    }

    @Step("Get uploaded file name")
    public String getUploadedFileName(){
        return this.formFileUploaded.getText();
    }

}
