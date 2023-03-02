package enums;

public enum AlertMsgs {
    CONTENT_MENU_ALERT("You selected a context menu");

    private final String message;

    AlertMsgs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
