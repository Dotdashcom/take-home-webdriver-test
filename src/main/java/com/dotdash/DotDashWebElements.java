package com.dotdash;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashWebElements {

    // Login Page
    public static final String userNameTxtFieldID = "#username";
    public static final String passwordTxtFieldID = "#password";
    public static final String loginButtonClass = ".radius";
    public static final String loginMessageID = "#flash";

    // Checkboxes Page
    public static final String checkBox1Xp = "//form[@id='checkboxes'][input[1]]";
    public static final String checkBox2Xp = "//form[@id='checkboxes'][input[2]]";

    // Context Menu Page
    public static final String fieldMenuID = "#hot-spot";

    // Drag and Drop
    public static final String pointAID = "#column-a";
    public static final String pointBID = "#column-b";

    // Drop Down Page
    public static final String dropDownID = "#dropdown";

    // Content Page
    public static final String contentID = "#content";

    // Dynamic Controls Page
    public static final String enableButtonXp = "//button[contains(text(),'Enable')]";
    public static final String removeButtonXp = "//button[contains(text(),'Remove')]";
    public static final String addButtonXp = "//button[contains(text(),'Add')]";
    public static final String textBoxXp = "//input[@type='text']";

    // Dynamic Loading Page
    public static final String startButtonXp = "//button";
    public static final String helloWorldMessageCss = "#finish";

    // Download Page
    public static final String txtFileLT = "some-file.txt";

    // Upload Page
    public static final String uploadButtonCss = "#file-upload";
    public static final String uploadSubmitButtonCss = "#file-submit";
    public static final String fileUploadedMessageXp = "//h3[contains(text(),'File Uploaded!')]";
    public static final String dragDropFieldCss = ".dz-success-mark.dz-clickable.dz-started";
    public static final String hiddenInputCss = ".dz-hidden-input";

    // Floating Menu Page
    public static final String newsLT = "News";
    public static final String contactLT = "Contact";
    public static final String aboutLT = "About";
    public static final String homeLT = "Home";

    // iFrame Page
    public static final String iFrameCss = "#mce_0_ifr";
    public static final String iFrameTxtFieldCss = "#tinymce";

    // User Mouse Hover Page
    public static final String user1TextXp = "//h5[text()='name: user1']";
    public static final String user2TextXp = "//h5[text()='name: user2']";
    public static final String user3TextXp = "//h5[text()='name: user3']";
    public static final String user1Xp = "//div[@class='example']//div[1]//img[1]";
    public static final String user2Xp = "//div[@class='row']//div[2]//img[1]";
    public static final String user3Xp = "//div[3]//img[1]";

    // Alerts Page
    public static final String jsAlertXp = "//button[contains(text(),'Click for JS Alert')]";
    public static final String jsAlertConfirmXp = "//button[contains(text(),'Click for JS Confirm')]";
    public static final String jsAlertPromptXp = "//button[contains(text(),'Click for JS Prompt')]";
    public static final String promptResultCss = "#result";

    // Tabs Window
    public static final String clickHereLT = "Click Here";

    // Notification Message Page
    public static final String clickHereNotificationLT = "Click here";
    public static final String notificationMessageCss = "#flash";

}
