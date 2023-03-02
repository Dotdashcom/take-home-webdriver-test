package enums;

public enum Messages {

    SUCCESS("You logged into a secure area!"),
    FAIL("Your username is invalid!"),
    MESSAGE("Hello World!"),
    SUCCESFUL_MESSAGE("Action successful"),
    UNSUCCESFUL_MESSAGE("Action unsuccesful, please try again");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
