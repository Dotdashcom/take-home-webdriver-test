$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/01_Login.feature");
formatter.feature({
  "name": "Login",
  "description": "  Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!\n  Login Failure: http://localhost:7080/login Login fail invalid credentials",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login with valid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters valid \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\" and clicks on login button",
  "keyword": "When "
});
formatter.step({
  "name": "user is on \"Secure Area\" and see \"\u003cSuccessfulLoginMessage\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "SuccessfulLoginMessage"
      ]
    },
    {
      "cells": [
        "tomsmith",
        "SuperSecretPassword!",
        "You logged into a secure area!"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters valid \"tomsmith\" and \"SuperSecretPassword!\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_enters_valid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on \"Secure Area\" and see \"You logged into a secure area!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_and_see(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters invalid \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\" and clicks on login button",
  "keyword": "When "
});
formatter.step({
  "name": "user sees \"\u003cerrorMessage\u003e\" is displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "errorMessage"
      ]
    },
    {
      "cells": [
        "invalid",
        "SuperSecretPassword!",
        "Your username is invalid!"
      ]
    },
    {
      "cells": [
        "",
        "SuperSecretPassword!",
        "Your username is invalid!"
      ]
    },
    {
      "cells": [
        "",
        "",
        "Your username is invalid!"
      ]
    },
    {
      "cells": [
        "tomsmith",
        "invalid",
        "Your password is invalid!"
      ]
    },
    {
      "cells": [
        "tomsmith",
        "",
        "Your password is invalid!"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters invalid \"invalid\" and \"SuperSecretPassword!\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_enters_invalid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Your username is invalid!\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters invalid \"\" and \"SuperSecretPassword!\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_enters_invalid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Your username is invalid!\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters invalid \"\" and \"\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_enters_invalid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Your username is invalid!\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters invalid \"tomsmith\" and \"invalid\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_enters_invalid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Your password is invalid!\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message validation while invalid login",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user enters invalid \"tomsmith\" and \"\" and clicks on login button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_enters_invalid_and_and_clicks_on_login_button(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Your password is invalid!\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_sees_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Checkboxes.feature");
formatter.feature({
  "name": "Checkboxes",
  "description": "  CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check and uncheck boxes",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/checkboxes\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on checkboxes",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CheckboxesPageSteps.user_clicks_on_checkboxes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"checkbox 1\" and \"checkbox 2\" work correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CheckboxesPageSteps.user_sees_and_work_correctly(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/ContexMenu.feature");
formatter.feature({
  "name": "Context Menu",
  "description": "  CContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called \u0027the-internet\u0027. Test JavaScript alert text on Right-Click.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Context click functionality",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/context_menu\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user performs right click on the box",
  "keyword": "When "
});
formatter.match({
  "location": "steps.ContextMenuPageSteps.user_performs_right_click_on_the_box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Javascript alert is triggered and text \"You selected a context menu\" is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.ContextMenuPageSteps.javascript_alert_is_triggered_and_text_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/DragAndDrop.feature");
formatter.feature({
  "name": "Drag and Drop",
  "description": "  Drag and Drop: http://localhost:7080/drag_and_drop Perform Drag And Drop in a WebDriver test.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Drag and drop functionality",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/drag_and_drop\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user drags one square and drops on another square",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DragAndDropPageSteps.user_drags_one_square_and_drops_on_another_square()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees boxes \"A\" and \"B\" are swapped",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.DragAndDropPageSteps.user_sees_boxes_and_are_swapped(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Dropdown.feature");
formatter.feature({
  "name": "Dropdown",
  "description": "  Dropdown: http://localhost:7080/dropdown Test dropdown using WebDriver.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dropdown verification",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/dropdown\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects \"Option 2\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DropdownPageSteps.user_selects(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Option 2\" selected successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.DropdownPageSteps.selected_successfully(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/DynamicContent.feature");
formatter.feature({
  "name": "Dynamic Content",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dynamic Content",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/dynamic_content\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user refreshes the page",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DynamicContentPageSteps.user_refreshes_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees content is updated",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.DynamicContentPageSteps.user_sees_content_is_updated()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/DynamicControls.feature");
formatter.feature({
  "name": "Dynamic Controls",
  "description": "  Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dynamic Controls",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/dynamic_controls\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks Remove button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DynamicControlsPageElements.user_clicks_Remove_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"It\u0027s gone!\" and checkbox is removed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.DynamicControlsPageElements.user_sees_and_checkbox_is_removed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks Add button and check the checkbox",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DynamicControlsPageElements.user_clicks_Add_button_and_check_the_checkbox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users sees checkbox checked",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.DynamicControlsPageElements.users_sees_checkbox_checked()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users clicks on Enable button and send text \"Hello!\" to the text box",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DynamicControlsPageElements.users_clicks_on_Enable_button_and_send_text_to_the_text_box(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "users sees \"It\u0027s enabled!\" and text into the text \"Hello!\" box",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.DynamicControlsPageElements.users_sees_and_text_into_the_text_box(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/DynamicLoading.feature");
formatter.feature({
  "name": "Dynamic Loading",
  "description": "  Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dynamic Loading",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/dynamic_loading/2\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks Start button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.DynamicLoadingPageSteps.user_clicks_Start_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"Hello World!\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.DynamicLoadingPageSteps.user_sees(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/FileDownload.feature");
formatter.feature({
  "name": "File Download",
  "description": "  File Download: http://localhost:7080/download Test File Download.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "File Download",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/download\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks link to download file",
  "keyword": "When "
});
formatter.match({
  "location": "steps.FileDownloadPageSteps.user_clicks_link_to_download_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees file \"some-file.txt\" downloaded to the folder \"/Users/robespierre/Downloads\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.FileDownloadPageSteps.user_sees_file_downloaded_to_the_folder(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/FileUpload.feature");
formatter.feature({
  "name": "File Upload",
  "description": "  File Upload: http://localhost:7080/upload Test File Upload.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "File Upload",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/upload\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user chooses the file \"/Users/robespierre/Downloads/fileToUpload.txt\" to upload and clicks on Upload button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.FileUploadPageSteps.user_chooses_the_file_to_upload_and_clicks_on_Upload_button(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"fileToUpload.txt\" file successfully uploaded",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.FileUploadPageSteps.user_sees_file_successfully_uploaded(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/FloatingMenu.feature");
formatter.feature({
  "name": "Floating Menu",
  "description": "  Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Floating Menu",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/floating_menu\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user scrolls down 1000 the page",
  "keyword": "When "
});
formatter.match({
  "location": "steps.FloatingMenuPageSteps.user_scrolls_down_the_page(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees the menu buttons are visible and accessible",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.FloatingMenuPageSteps.user_sees_the_menu_buttons_are_visible_and_accessible()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Iframe.feature");
formatter.feature({
  "name": "iFrame",
  "description": "  iFrame: http://localhost:7080/iframe Test iFrame.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "iFrame",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/iframe\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User able to enter \"Text\" into the textBox",
  "keyword": "When "
});
formatter.match({
  "location": "steps.IframePageSteps.user_able_to_enter_into_the_textBox(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User sees \"Text\" entered",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.IframePageSteps.user_sees_entered(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/JavascriptAlerts.feature");
formatter.feature({
  "name": "Javascript Alerts",
  "description": "  JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Javascript Alerts",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/javascript_alerts\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on buttons and interacts with \"Alert\" \"Confirm\" \"Prompt\" alerts, enters \"Hello\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.JavaScriptAlertsPageSteps.user_clicks_on_buttons_and_interacts_with_alerts_enters(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees corresponding result messages",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "steps.JavaScriptAlertsPageSteps.user_sees_corresponding_result_messages(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/JavascriptError.feature");
formatter.feature({
  "name": "Javascript Error",
  "description": "  JavaScript Error: http://localhost:7080/javascript_error Test JS error.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Javascript Error Test",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/javascript_error\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees the error and verifies \"JavaScript error\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.JavaScriptErrorPageSteps.user_sees_the_error_and_verifies(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/MouseHover.feature");
formatter.feature({
  "name": "Mouse Hover",
  "description": "  Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Mouse Hover",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/hovers\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user hovers on every users avatar",
  "keyword": "When "
});
formatter.match({
  "location": "steps.MouseHoverPageSteps.user_hovers_on_every_users_avatar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees additional information under Avatar",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "steps.MouseHoverPageSteps.user_sees_additional_information_under_Avatar(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on the profile link",
  "keyword": "When "
});
formatter.match({
  "location": "steps.MouseHoverPageSteps.user_clicks_on_the_profile_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees message \"Sinatra doesn’t know this ditty.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.MouseHoverPageSteps.user_sees_message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/NotificationMessage.feature");
formatter.feature({
  "name": "Notification Message",
  "description": "  Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Notification Message",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/notification_message_rendered\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the link to load the new message",
  "keyword": "When "
});
formatter.match({
  "location": "steps.NotificationMessagePageSteps.user_clicks_the_link_to_load_the_new_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees notification message",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "steps.NotificationMessagePageSteps.user_sees_notification_message(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/OpenInNewTab.feature");
formatter.feature({
  "name": "Open In Tab",
  "description": "  Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Open In Tab",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the Page \"http://localhost:7080/windows\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginPageSteps.user_is_on_the_Page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the link",
  "keyword": "When "
});
formatter.match({
  "location": "steps.OpeninNewTabPageSteps.user_clicks_the_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user sees \"New Window\" sign in newly opened window",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.OpeninNewTabPageSteps.user_sees_sign_in_newly_opened_window(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});