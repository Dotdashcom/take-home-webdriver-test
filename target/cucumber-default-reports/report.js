$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/01_Login.feature");
formatter.feature({
  "name": "The scenarios for the login page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
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
  "name": "navigate to the \u0027login\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@loginSuccess"
    }
  ]
});
formatter.step({
  "name": "verify login was successful",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.verify_login_was_successful()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "login with valid credentials");
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
  "name": "navigate to the \u0027login\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "login with an invalid username",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@loginFailureUsername"
    }
  ]
});
formatter.step({
  "name": "verify the error message for an invalid username",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.verify_the_error_message_for_an_invalid_username()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "login with an invalid username");
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
  "name": "navigate to the \u0027login\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "login with an invalid password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@loginFailurePassword"
    }
  ]
});
formatter.step({
  "name": "verify the error message for an invalid password",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.verify_the_error_message_for_an_invalid_password()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", "login with an invalid password");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/02_CheckBoxes.feature");
formatter.feature({
  "name": "The scenarios for the CheckBoxes page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@CheckBoxes"
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
  "name": "navigate to the \u0027checkboxes\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "select all checkboxes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@CheckBoxes"
    },
    {
      "name": "@CheckBoxesChecked"
    }
  ]
});
formatter.step({
  "name": "check all checkboxes",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsCheckBoxes.check_all_checkboxes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify all checkboxes are checked",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsCheckBoxes.verify_all_checkboxes_are_checked()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "select all checkboxes");
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
  "name": "navigate to the \u0027checkboxes\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "deselect all checkboxes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@CheckBoxes"
    },
    {
      "name": "@CheckBoxesUnchecked"
    }
  ]
});
formatter.step({
  "name": "unchecked all checkboxes",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsCheckBoxes.unchecked_all_checkboxes()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify all checkboxes are unchecked",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsCheckBoxes.verify_all_checkboxes_are_unchecked()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png", "deselect all checkboxes");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/03_ContextMenu.feature");
formatter.feature({
  "name": "The scenarios for the ContextMenu page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ContextMenu"
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
  "name": "navigate to the \u0027context_menu\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test right click on the context menu",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ContextMenu"
    },
    {
      "name": "@ContextMenuRightClick"
    }
  ]
});
formatter.step({
  "name": "right click on the context menu",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsContextMenu.right_click_on_the_context_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the alert menu text",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsContextMenu.verify_the_alert_menu_text()"
});
formatter.embedding("image/png", "embedded5.png", "Test right click on the context menu");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded6.png", "Test right click on the context menu");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/04_DragAndDrop.feature");
formatter.feature({
  "name": "The scenarios for the Drag and Drop page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DragAndDrop"
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
  "name": "navigate to the \u0027drag_and_drop\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test drags element A to element B",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DragAndDrop"
    },
    {
      "name": "@testDragAndDrop"
    }
  ]
});
formatter.step({
  "name": "drag element A to element B",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDragAndDrop.drag_element_A_to_element_B()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the text on elements A and B are switched",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDragAndDrop.verify_the_text_on_elements_A_and_B_are_switched()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded7.png", "Test drags element A to element B");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/05_Dropdown.feature");
formatter.feature({
  "name": "The scenarios for the Dropdown page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Dropdown"
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
  "name": "navigate to the \u0027dropdown\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test selects Option 1 from the drop-down menu",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Dropdown"
    },
    {
      "name": "@testDropdown1"
    }
  ]
});
formatter.step({
  "name": "select \u0027Option 1\u0027 from the drop-down menu and verify it was selected",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDropdown.select_from_the_drop_down_menu_and_verify_it_was_selected(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded8.png", "Test selects Option 1 from the drop-down menu");
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
  "name": "navigate to the \u0027dropdown\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test selects Option 2 from the drop-down menu",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Dropdown"
    },
    {
      "name": "@testDropdown2"
    }
  ]
});
formatter.step({
  "name": "select \u0027Option 2\u0027 from the drop-down menu and verify it was selected",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDropdown.select_from_the_drop_down_menu_and_verify_it_was_selected(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded9.png", "Test selects Option 2 from the drop-down menu");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/06_DynamicContent.feature");
formatter.feature({
  "name": "The scenarios for the Dynamic Content page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DynamicContent"
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
  "name": "navigate to the \u0027dynamic_content\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test Dynamic Content",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DynamicContent"
    },
    {
      "name": "@testDynamicContent"
    }
  ]
});
formatter.step({
  "name": "refresh page 5 times and verify the content changes on each refresh",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicContent.refresh_page_times_and_verify_the_content_changes_on_each_refresh(java.lang.Integer)"
});
formatter.embedding("image/png", "embedded10.png", "Test Dynamic Content");
formatter.embedding("image/png", "embedded11.png", "Test Dynamic Content");
formatter.embedding("image/png", "embedded12.png", "Test Dynamic Content");
formatter.embedding("image/png", "embedded13.png", "Test Dynamic Content");
formatter.embedding("image/png", "embedded14.png", "Test Dynamic Content");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded15.png", "Test Dynamic Content");
formatter.after({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\tdid not expect [http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-2.jpg] but found [http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-2.jpg]\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\n\tat com.QA.testSteps.AA_Hooks.end(AA_Hooks.java:48)\n",
  "status": "failed"
});
formatter.uri("file:src/test/resources/features/07_DynamicControls.feature");
formatter.feature({
  "name": "The scenarios for the Dynamic Controls page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DynamicControls"
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
  "name": "navigate to the \u0027dynamic_controls\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test Dynamic Controls",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DynamicControls"
    },
    {
      "name": "@testDynamicControls"
    }
  ]
});
formatter.step({
  "name": "click on the Remove button",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.click_on_the_Remove_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the checkbox is gone",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.verify_that_the_checkbox_is_gone()"
});
formatter.embedding("image/png", "embedded16.png", "Test Dynamic Controls");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Add button",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.click_on_Add_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the checkbox is present",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.verify_that_the_checkbox_is_present()"
});
formatter.embedding("image/png", "embedded17.png", "Test Dynamic Controls");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Enable button",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.click_on_the_Enable_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the text box is enabled",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.verify_that_the_text_box_is_enabled()"
});
formatter.embedding("image/png", "embedded18.png", "Test Dynamic Controls");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the Disable button",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.click_on_the_Disable_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the text box is disabled",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicControls.verify_that_the_text_box_is_disabled()"
});
formatter.embedding("image/png", "embedded19.png", "Test Dynamic Controls");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded20.png", "Test Dynamic Controls");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/08_DynamicLoading.feature");
formatter.feature({
  "name": "The scenarios for the Dynamic Loading page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@DynamicLoading"
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
  "name": "navigate to the \u0027dynamic_loading/2\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test Dynamic Loading",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DynamicLoading"
    },
    {
      "name": "@testDynamicLoading"
    }
  ]
});
formatter.step({
  "name": "click the start button",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicLoading.click_the_start_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that \u0027Hello World!\u0027 text is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsDynamicLoading.verify_that_text_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded21.png", "Test Dynamic Loading");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/09_FileDownload.feature");
formatter.feature({
  "name": "The scenarios for the File Download page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@FileDownload"
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
  "name": "navigate to the \u0027download\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test File Download",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@FileDownload"
    },
    {
      "name": "@testFileDownload"
    }
  ]
});
formatter.step({
  "name": "click on the file",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsFileDownload.click_on_the_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the file is downloaded",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsFileDownload.verify_that_the_file_is_downloaded()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded22.png", "Test File Download");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/10_FileUpload.feature");
formatter.feature({
  "name": "The scenarios for the File Upload page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@FileUpload"
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
  "name": "navigate to the \u0027upload\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test File Uploader",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@FileUpload"
    },
    {
      "name": "@testFileUpload"
    }
  ]
});
formatter.step({
  "name": "choose a file and click upload button to upload a file",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsFileUpload.choose_a_file_and_click_upload_button_to_upload_a_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the file is uploaded",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsFileUpload.verify_that_the_file_is_uploaded()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded23.png", "Test File Uploader");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/11_FloatingMenu.feature");
formatter.feature({
  "name": "The scenarios for the Floating Menu page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@FloatingMenu"
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
  "name": "navigate to the \u0027floating_menu\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test the floating menu",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@FloatingMenu"
    },
    {
      "name": "@testFloatingMenu"
    }
  ]
});
formatter.step({
  "name": "scroll the page",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsFloatingMenu.scroll_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the floating menu is still displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsFloatingMenu.verify_the_floating_menu_is_still_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded24.png", "Test the floating menu");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/12_Iframe.feature");
formatter.feature({
  "name": "The scenarios for the Iframe page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Iframe"
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
  "name": "navigate to the \u0027iframe\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test Iframe",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Iframe"
    },
    {
      "name": "@testIframe"
    }
  ]
});
formatter.step({
  "name": "switch to Iframe and types some text",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsIframe.switch_to_Iframe_and_types_some_text()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the typed text is as expected",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsIframe.verify_that_the_typed_text_is_as_expected()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded25.png", "Test Iframe");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/13_MouseHover.feature");
formatter.feature({
  "name": "The scenarios for the Mouse Hover page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@MouseHover"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Test mouse hover on \u0027\u003cnumber\u003e\u0027 image",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@testMouseHover"
    }
  ]
});
formatter.step({
  "name": "do a mouse hover on \u0027\u003cnumber\u003e\u0027 image",
  "keyword": "And "
});
formatter.step({
  "name": "verify that additional information is displayed for \u0027\u003cnumber\u003e\u0027 image",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "number"
      ]
    },
    {
      "cells": [
        "1"
      ]
    },
    {
      "cells": [
        "2"
      ]
    },
    {
      "cells": [
        "3"
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
  "name": "navigate to the \u0027hovers\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test mouse hover on \u00271\u0027 image",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@MouseHover"
    },
    {
      "name": "@testMouseHover"
    }
  ]
});
formatter.step({
  "name": "do a mouse hover on \u00271\u0027 image",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsMouseHover.do_a_mouse_hover_on_image(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that additional information is displayed for \u00271\u0027 image",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsMouseHover.verify_that_additional_information_is_displayed_for_image(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded26.png", "Test mouse hover on \u00271\u0027 image");
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
  "name": "navigate to the \u0027hovers\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test mouse hover on \u00272\u0027 image",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@MouseHover"
    },
    {
      "name": "@testMouseHover"
    }
  ]
});
formatter.step({
  "name": "do a mouse hover on \u00272\u0027 image",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsMouseHover.do_a_mouse_hover_on_image(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that additional information is displayed for \u00272\u0027 image",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsMouseHover.verify_that_additional_information_is_displayed_for_image(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded27.png", "Test mouse hover on \u00272\u0027 image");
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
  "name": "navigate to the \u0027hovers\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test mouse hover on \u00273\u0027 image",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@MouseHover"
    },
    {
      "name": "@testMouseHover"
    }
  ]
});
formatter.step({
  "name": "do a mouse hover on \u00273\u0027 image",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsMouseHover.do_a_mouse_hover_on_image(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that additional information is displayed for \u00273\u0027 image",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsMouseHover.verify_that_additional_information_is_displayed_for_image(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded28.png", "Test mouse hover on \u00273\u0027 image");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/14_JavaScriptAlerts.feature");
formatter.feature({
  "name": "The scenarios for the JavaScript Alerts page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@JavaScriptAlerts"
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
  "name": "navigate to the \u0027javascript_alerts\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test JavaScript Alerts",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@JavaScriptAlerts"
    },
    {
      "name": "@testJavaScriptAlerts"
    }
  ]
});
formatter.step({
  "name": "click on JS Alert button and accept alert",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsJavaScriptAlerts.click_on_JS_Alert_button_and_accept_alert()"
});
formatter.embedding("image/png", "embedded29.png", "Test JavaScript Alerts");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify alert message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsJavaScriptAlerts.verify_alert_message()"
});
formatter.embedding("image/png", "embedded30.png", "Test JavaScript Alerts");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on JS confirm button and click ok on alert",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsJavaScriptAlerts.click_on_JS_confirm_button_and_click_ok_on_alert()"
});
formatter.embedding("image/png", "embedded31.png", "Test JavaScript Alerts");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify new alert message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsJavaScriptAlerts.verify_new_alert_message()"
});
formatter.embedding("image/png", "embedded32.png", "Test JavaScript Alerts");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on JS Prompt button and type a message on Prompt",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsJavaScriptAlerts.click_on_JS_Prompt_button_and_type_a_message_on_Prompt()"
});
formatter.embedding("image/png", "embedded33.png", "Test JavaScript Alerts");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the alert message contains the typed message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsJavaScriptAlerts.verify_that_the_alert_message_contains_the_typed_message()"
});
formatter.embedding("image/png", "embedded34.png", "Test JavaScript Alerts");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded35.png", "Test JavaScript Alerts");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/15_JavaScriptError.feature");
formatter.feature({
  "name": "The scenarios for the JavaScript Error page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@JavaScriptError"
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
  "name": "navigate to the \u0027javascript_error\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Finds the JavaScript error on the page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@JavaScriptError"
    },
    {
      "name": "@testJavaScriptError"
    }
  ]
});
formatter.step({
  "name": "verify that the page contains error: Cannot read property \u0027xyz\u0027 of undefined.",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsJavaScriptError.verify_that_the_page_contains_error_Cannot_read_property_of_undefined(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded36.png", "Finds the JavaScript error on the page");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/16_OpenInNewTab.feature");
formatter.feature({
  "name": "The scenarios for the Open In New Tab page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@OpenInNewTab"
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
  "name": "navigate to the \u0027windows\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Opening a new window",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@OpenInNewTab"
    },
    {
      "name": "@testOpenInNewTab"
    }
  ]
});
formatter.step({
  "name": "click on the Click Here link",
  "keyword": "And "
});
formatter.match({
  "location": "com.QA.testSteps.stepsOpenInNewTab.click_on_the_Click_Here_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that a new tab is opened with text \u0027New Window\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsOpenInNewTab.verify_that_a_new_tab_is_opened_with_text(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded37.png", "Opening a new window");
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/17_NotificationMessage.feature");
formatter.feature({
  "name": "The scenarios for the Notification Message page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@NotificationMessage"
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
  "name": "navigate to the \u0027notification_message_rendered\u0027 page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.QA.testSteps.stepsLogin.navigate_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test Notification Message",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@NotificationMessage"
    },
    {
      "name": "@testNotificationMessage"
    }
  ]
});
formatter.step({
  "name": "click on the Click Here link 7 times and verify that one of the messages shows on click",
  "keyword": "Then "
});
formatter.match({
  "location": "com.QA.testSteps.stepsNotificationMessage.click_on_the_Click_Here_link_times_and_verify_that_one_of_the_messages_shows_on_click(java.lang.Integer)"
});
formatter.embedding("image/png", "embedded38.png", "Test Notification Message");
formatter.embedding("image/png", "embedded39.png", "Test Notification Message");
formatter.embedding("image/png", "embedded40.png", "Test Notification Message");
formatter.embedding("image/png", "embedded41.png", "Test Notification Message");
formatter.embedding("image/png", "embedded42.png", "Test Notification Message");
formatter.embedding("image/png", "embedded43.png", "Test Notification Message");
formatter.embedding("image/png", "embedded44.png", "Test Notification Message");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded45.png", "Test Notification Message");
formatter.after({
  "error_message": "java.lang.AssertionError: The following asserts failed:\n\tThe incorrect message displayed: Action unsuccesful, please try again,\n\tThe incorrect message displayed: Action successful,\n\tThe incorrect message displayed: Action unsuccesful, please try again,\n\tThe incorrect message displayed: Action unsuccesful, please try again,\n\tThe incorrect message displayed: Action successful,\n\tThe incorrect message displayed: Action successful,\n\tThe incorrect message displayed: Action unsuccesful, please try again,\n\tMessage: Action Successful. Was not displayed expected [true] but found [false],\n\tMessage: Action unsuccessful, please try again. Was not displayed expected [true] but found [false],\n\tMessage: Action Unsuccessful. Was not displayed expected [true] but found [false]\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:47)\n\tat org.testng.asserts.SoftAssert.assertAll(SoftAssert.java:31)\n\tat com.QA.testSteps.AA_Hooks.end(AA_Hooks.java:48)\n",
  "status": "failed"
});
});