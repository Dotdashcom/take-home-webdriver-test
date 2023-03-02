package enums;

import utilities.ConfigurationReader;

public enum Pages {

    BASE_PAGE(ConfigurationReader.getProperty("base_url")),
    LOGIN_PAGE(BASE_PAGE.getUrl() + "/login"),
    CHECKBOX_PAGE(BASE_PAGE.getUrl() + "/checkboxes"),
    CONTENT_MENU_PAGE(BASE_PAGE.getUrl() + "/context_menu"),
    DRAG_AND_DROP_PAGE(BASE_PAGE.getUrl() + "/drag_and_drop"),
    DROPDOWN_PAGE(BASE_PAGE.getUrl() + "/dropdown"),
    DYNAMIC_CONTENT_PAGE(BASE_PAGE.BASE_PAGE.getUrl() + "/dynamic_content"),
    DYNAMIC_CONTROLS_PAGE(BASE_PAGE.BASE_PAGE.getUrl() + "/dynamic_controls"),
    DYNAMICALLY_LOADED_PAGE(BASE_PAGE.getUrl() + "/dynamic_loading/2"),
    FILE_DOWNLOADER_PAGE(BASE_PAGE.getUrl() + "/download"),
    FILE_UPLOAD_PAGE(BASE_PAGE.getUrl() + "/upload"),
    FLOATING_MENU_PAGE(BASE_PAGE.getUrl() + "/floating_menu"),
    IFRAME_PAGE(BASE_PAGE.getUrl() + "/iframe"),
    MOUSE_HOVER_PAGE(BASE_PAGE.getUrl() + "/hovers"),
    JSALERT_PAGE(BASE_PAGE.getUrl() + "/javascript_alerts"),
    NEW_WINDOW_PAGE(BASE_PAGE.getUrl() + "/windows"),
    NOTIFICATION_MESSAGE_PAGE(BASE_PAGE.getUrl() + "/notification_message_rendered"),
    JAVASCRIPT_ERROR_PAGE(BASE_PAGE.getUrl() + "/javascript_error");

    private final String url;

    Pages(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
