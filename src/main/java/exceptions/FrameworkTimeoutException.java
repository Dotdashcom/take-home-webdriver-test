package exceptions;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

import static java.lang.String.format;

public class FrameworkTimeoutException extends AssertionError {

    public static final String TIMEOUT_MESSAGE = "Test timed out after waiting";

    public FrameworkTimeoutException(String message, long time, TemporalUnit unit) {
        super(format(TIMEOUT_MESSAGE + " %s seconds for condition: %s", Duration.of(time, unit).getSeconds(), message));
    }
}
