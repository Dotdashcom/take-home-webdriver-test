package dotdash.automation.helpers;

public class ConfigReaderPropertyNotFoundException extends RuntimeException {
    public ConfigReaderPropertyNotFoundException() {
        super("Property not found in the configuration.");
    }

    public ConfigReaderPropertyNotFoundException(String message) {
        super(message);
    }
}
