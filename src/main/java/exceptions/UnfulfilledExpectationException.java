package exceptions;

import org.junit.AssumptionViolatedException;

public class UnfulfilledExpectationException extends AssumptionViolatedException {

    public UnfulfilledExpectationException(String message) {
        super(message);
    }

}
