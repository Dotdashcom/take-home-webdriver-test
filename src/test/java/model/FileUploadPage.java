package model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import model.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.BaseUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileUploadPage extends BasePage {

    private static final String UPLOAD_ENDPOINT = "upload";
    private static final String fileNameToUpload = "TheBestCandidateResume.txt";
    private static final String resumeContent = "OVERVIEW\n" +
            "-\tVersatile, goal oriented hard-working QA Analyst with 5+ years of experience as a System Integration Analyst and Quality Assurance with automation and manual testing for web applications\n" +
            "-\tStrong experience in requirements matrix, project planning, scheduling, testing, defect tracking and reporting, creating from scratch and executing automated tests for web application testing \n" +
            "-\tWorking well under pressure and easily adaptive to any working environment. Able to compete for deadlines and prioritize tasks\n" +
            "-\tStrong analytical thinking, problem-solving, communication, and time-management skills\n" +
            "-\tGreat team and independent work skills\n" +
            "-\tQuick learner open to new techniques, methodologies, practices\n" +
            "-\tAchieved positive growing results both individually and within teams, with successful experience in training, coaching and leading the teammates\n" +
            "\n" +
            "Languages: Java (working knowledge), JavaScript (basics), Python (basics), Gherkin (basics)\n" +
            "Frameworks: Selenium, TestNG, Cucumber, Junit\n" +
            "VCS: Github\n" +
            "Reporting system: Trello, Jira, Zephyr\n" +
            "Supporting tools: HTML, CSS, MS Excel, Slack, Google Sheets, IntelliJ IDE, PyCharm, MS Visual Code\n" +
            "\n" +
            "WORK EXPERIENCE\n" +
            "Automation QA Analyst. Reborn Crypto (startup), 09/2021 – 11/2022 \n" +
            "-\tGathered requirements, found dependencies between components and modules of the web application, developed test cases based on user stories and functional requirements\n" +
            "-\tWorked closely with Project Manager, and Product Development teams from design through product release and ensured that every problem in the product is reported and the fix is tested promptly\n" +
            "-\tDeveloped and maintained an automation framework for functional testing, smoke testing, and regression testing for web applications\n" +
            "-\tPerformed manual testing\n" +
            "-\tImplemented and executed 200+ automated test cases for the Reborn Crypto web app, increasing up to 90% test coverage of regression testing\n" +
            "-\tIntroduced and implemented a set of synthetic test data making test automation fully independent of real customer's data\n" +
            "-\tAssisted in creating test planning and test strategy, creation of status reports\n" +
            "-\tReported 200+ bugs in UI and UX performance to the development team and tracked them to resolution\n" +
            "\n" +
            "System Integration Analyst, Davidson Hospitality Group, 06/2020 – 08/2021\n" +
            "-\tTook over the hotel management system training process, trained, coached front desk and reservation teams on best practices, procedures and usage of Oracle Opera Property Management System. Trained teams of 5-9 people with the total number of 33 people which increased team efficiency by 25% \n" +
            "-\tSet up connection between online travel agency extranet booking and the property booking engine. Increased the number of interfaced connections by 500% and booking revenue by 75%\n" +
            "-\tReviewed bugs and errors in interface communication, analyzed bug reports in XML files. Increased the number of interfaced connections by 500%\n" +
            "-\tSet up and monitored interfaced connection between Oracle Java-based Opera Cloud Property Management System and online booking engine. Monitored bug and error reports, performed manual testing of the connections, investigated and reported bug causes. Reduced the number of critical bugs by 90% and the number of minor bugs by 70%\n" +
            "-\tCreated tickets and followed up with respective support and tech teams to resolve the issues. Implemented ticket lifecycle management which reduced the time spent on tickets and follow ups from 14 hours a week to 2 hours\n" +
            "\n" +
            "System Integration Analyst, Highgate Hotels, 02/2014 – 05/2020\n" +
            "-\tAssisted with interface configuration between the online booking engine and online travel agency extranets using API tokens, which reduced the reservation manual processing time from 20 hours a week to 6 hours a week\n" +
            "-\tCreated simple SQL queries in the property management system to create ad hoc and custom reports, presented reports to the hotel management, corporate team and ownership\n" +
            "-\tWorked on finding post production bugs in various revenue management systems, property management systems, booking engines\n" +
            "-\tConfigured PMS and set up interfaced connection to online travel agency extranets\n" +
            "-\tCreated and distributed revenue management reports in Excel with the use of Visual Basic for Applications which allowed to increase the speed, accuracy and usability for all recipients and users\n" +
            "\n" +
            "Front Office Supervisor, Silver Palms Inn, 09/2011 – 01/2014 \n" +
            "-\tSupervised the team of 6 front desk agents to success by coaching, training, motivating. Set the goals high and provide the means to achieve them\n" +
            "-\tResolved any issues that are escalated from the front line\n" +
            "-\tServed as a source of information on guest satisfaction questions, PMS technical questions\n" +
            "-\tInspired the front desk team to increase upsell efficiency and contributed to $10,000 upsell revenue monthly (4% monthly revenue increase)\n" +
            "-\tReceive annual rewards from ownership for outstanding performance in 2012 through 2014\n" +
            "-\tSuggested and created SOPs and guides for front desk team members to uniform operations and to streamline new hires training process\n" +
            "\n" +
            "EDUCATION\n" +
            "Buryat State University, Russia, BS in Business Management\n";

    @FindBy(css = "#file-upload")
    private WebElement chooseUploadFileButton;

    @FindBy(css = "#file-submit")
    private WebElement uploadFileButton;

    @FindBy(css = "#drag-drop-upload")
    private WebElement dragAndDropFileArea;

    @FindBy(css = "#uploaded-files")
    private WebElement uploadedFileConfirmationText;

    @FindBy(css = ".dz-success-mark .dz-preview .dz-details span")
    private List<WebElement> draggedAndDroppedFileNameList;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public FileUploadPage getFileUploadPage() {
        getDriver(UPLOAD_ENDPOINT);

        return this;
    }

    public FileUploadPage chooseUploadFile() {
        chooseUploadFileButton.sendKeys(getDefaultDownloadFolder()+ fileNameToUpload);

        return this;
    }

    public FileUploadPage clickUploadButton() {
        uploadFileButton.click();

        return this;
    }

    public String getUploadedFileConfirmationText() {

        return uploadedFileConfirmationText.getText();
    }

    public String getFileNameToUpload() {

        return fileNameToUpload;
    }

    public FileUploadPage dragAndDropFile() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        int offsetX = dragAndDropFileArea.getLocation().getX();
        int offsetY = dragAndDropFileArea.getLocation().getY();
                String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input = (WebElement)jse.executeScript(JS_DROP_FILE, dragAndDropFileArea,offsetX, offsetY);
        input.sendKeys(getDefaultDownloadFolder()+ fileNameToUpload);

        return this;
    }

    public boolean isFileToUploadAddedToDragAndDropArea() {

        return draggedAndDroppedFileNameList.stream().anyMatch(element -> element.getText().equals(fileNameToUpload));
    }

    public boolean areMultipleFileAddedToDragAndDropArea(int numberOfFiles) {
        for(int i = 0; i < numberOfFiles; i++) {
            dragAndDropFile();
        }

        return draggedAndDroppedFileNameList.size() == numberOfFiles;
    }

    public FileUploadPage createFileToUpload() {
        String absoluteFilePath = getDefaultDownloadFolder() + fileNameToUpload;
        File defaultDownloadFolder = new File(getDefaultDownloadFolder());
        boolean isFileAlreadyDownloadedInDefaultDownloadFolder = true;

        try {
            BaseUtils.log("Checking if the file exists...");
            if(Arrays.stream(
                            defaultDownloadFolder.list())
                    .anyMatch(element->element.equals(fileNameToUpload))
            ) {
                BaseUtils.log("File does not exist");
                isFileAlreadyDownloadedInDefaultDownloadFolder = true;
            } else {
                BaseUtils.log("File exists");
                isFileAlreadyDownloadedInDefaultDownloadFolder = false;
            }
        } catch(NullPointerException e) {
            BaseUtils.log("Error when getting the file list");
            isFileAlreadyDownloadedInDefaultDownloadFolder = false;
            e.fillInStackTrace();
        }

        if(isFileAlreadyDownloadedInDefaultDownloadFolder) {
            try {
                BaseUtils.log("Deleting the existing file...");
                File existingFile = new File(getDefaultDownloadFolder() + fileNameToUpload);
                existingFile.delete();
                BaseUtils.log("The file is deleted");
            } catch (Exception e) {
                BaseUtils.log("Error when deleting the existing file");
                e.fillInStackTrace();
            }
        }

        BaseUtils.log("Creating the new file...");
        try {
            File myObj = new File(getDefaultDownloadFolder() + fileNameToUpload);
            if (myObj.createNewFile()) {
                BaseUtils.log(String.format("The file created: %s at %s", myObj.getName(), myObj.getAbsolutePath()));
                try {
                    FileWriter myResume = new FileWriter(absoluteFilePath);
                    myResume.write(resumeContent);
                    myResume.close();
                    BaseUtils.log("Resume successfully updated");
                } catch (IOException e) {
                    BaseUtils.log("Error when updating resume");
                    e.printStackTrace();
                }
            } else {
                BaseUtils.log("Something went wrong when creating the file");
            }
        } catch (IOException e) {
            BaseUtils.log("Error when creating a new file.");
            e.printStackTrace();
        }

        return this;
    }
}