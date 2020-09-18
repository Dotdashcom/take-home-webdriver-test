$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/DynamicLoading.feature");
formatter.feature({
  "name": "Dynamic Loading",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verification of Dynamic Loading",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Dynamic Loading page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.DynamicLoading.i_am_on_the_Dynamic_Loading_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert that  \"Hello World!\" text is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DynamicLoading.i_assert_that_text_is_displayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/checkbox.feature");
formatter.feature({
  "name": "Checkbox",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Checkbox verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the checkbox page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.Checkboxes.i_am_on_the_checkbox_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I varify checks and unchecks checkboxes",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.Checkboxes.i_varify_checks_and_unchecks_checkboxes()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/contextmenu.feature");
formatter.feature({
  "name": "Context menu",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Context menu verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the context menu page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.ContextMenu.i_am_on_the_context_menu_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I right click on the context menu",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.ContextMenu.i_right_click_on_the_context_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I varify the alert menu text",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.ContextMenu.i_varify_the_alert_menu_text()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/draganddrop.feature");
formatter.feature({
  "name": "Drag and Drop",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Drag and Drop verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the drag and drop page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.DragAndDrop.i_am_on_the_drag_and_drop_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I drag element A to element B",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.DragAndDrop.i_drag_element_A_to_element_B()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the text on element A and B are switched",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DragAndDrop.i_verify_the_text_on_element_A_and_B_are_switched()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/dropdown.feature");
formatter.feature({
  "name": "Dropdown",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dropdown verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the dropdown page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.DropDown.i_am_on_the_dropdown_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I varify Option1 and Option2  are selected",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DropDown.i_varify_Option1_and_Option2_are_selected()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/dynamiccontent.feature");
formatter.feature({
  "name": "Dynamic Content",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Dynacmic Content verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Dynacmic Content page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.DynamicContent.i_am_on_the_Dynacmic_Content_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I varify the content changes on each refresh.",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DynamicContent.i_varify_the_content_changes_on_each_refresh()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/dynamiccontrols.feature");
formatter.feature({
  "name": "Dynamic Controls",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verification and use of explicit wait",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Dynamic Controls page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_am_on_the_Dynamic_Controls_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Remove Button",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_click_on_the_Remove_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the checkbox is gone",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_verify_the_checkbox_is_gone()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Add Button",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_click_Add_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert that the checkbox is present",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_assert_that_the_checkbox_is_present()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Enanble Button",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_click_on_the_Enanble_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert that the text box is enabled",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_assert_that_the_text_box_is_enabled()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Disable Button",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_click_on_the_Disable_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert that the box is disabled",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.DynamicControls.i_assert_that_the_box_is_disabled()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/floatingmanu.feature");
formatter.feature({
  "name": "Floating Menu",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Floating Menu verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Floating Menu page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.FloatingMenu.i_am_on_the_Floating_Menu_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I scroll the page",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.FloatingMenu.i_scroll_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I varify that the floating menu is still displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.FloatingMenu.i_varify_that_the_floating_menu_is_still_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/iframe.feature");
formatter.feature({
  "name": "Iframe",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Working with Iframe",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Iframe page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.Iframe.i_am_on_the_Iframe_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I switch to Iframe and type some text",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.Iframe.i_switch_to_Iframe_and_type_some_text()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify that the typed text is as expected",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.Iframe.i_verify_that_the_typed_text_is_as_expected()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/javaScriptAlerts.feature");
formatter.feature({
  "name": "JavaScript Alerts",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Working with JavaScript Alerts",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the JavaScript Alerts  page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.JavaScriptAlerts.i_am_on_the_JavaScript_Alerts_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on JS Alert Button",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.JavaScriptAlerts.i_click_on_JS_Alert_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify alert message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.JavaScriptAlerts.i_verify_alert_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on JS confirm Button and click ok on alert",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.JavaScriptAlerts.i_click_on_JS_confirm_Button_and_click_ok_on_alert()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the alert message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.JavaScriptAlerts.i_verify_the_alert_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on JS Prompt Button and type a message on prompt",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.JavaScriptAlerts.i_click_on_JS_Prompt_Button_and_type_a_message_on_prompt()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify that the alert message contains the typed message.",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.JavaScriptAlerts.i_verify_that_the_alert_message_contains_the_typed_message()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Log in",
  "description": "",
  "keyword": "Feature"
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
  "name": "I am on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.LoginSuccess.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login Success",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.step({
  "name": "I enter username  \"tomsmith\" and password \"SuperSecretPassword!\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.LoginSuccess.i_enter_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I varify welcome message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.LoginSuccess.i_varify_welcome_message()"
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
  "name": "I am on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.LoginSuccess.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login Faile",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.step({
  "name": "I enter invalid  username  \"tomhanks\" and password \"SuperSecretPasswordInvalid!\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.LoginSuccess.i_enter_invalid_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I varify  message for invalid log in entry",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.LoginSuccess.i_varify_message_for_invalid_log_in_entry()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/mousehover.feature");
formatter.feature({
  "name": "Mouse Hover",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "verification of mouse hovering on each image",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the mouse hover page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.MouseHover.i_am_on_the_mouse_hover_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hover on each image I verify that additional information is displayed for each image",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.MouseHover.i_hover_on_each_image()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/notificationmessage.feature");
formatter.feature({
  "name": "Notification Message",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Work with Notification message",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Notification page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.NotificationMessage.i_am_on_the_Notification_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the Click Here link a multiple time and assert the message that has changed",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.NotificationMessage.i_click_on_the_Click_Here_link_a_multiple_time()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/openinnewtab.feature");
formatter.feature({
  "name": "Open In New Tab",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verifying  that the new tab opens",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the new tab page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.OpenNewTab.i_am_on_the_new_tab_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Here link",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.OpenNewTab.i_click_Here_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert that a new tab is opened with text New Window",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.OpenNewTab.i_assert_that_a_new_tab_is_opened_with_text_New_Window()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});