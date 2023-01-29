package lab4.exceptions;

public class ProhibitedActionException extends Exception {

    public ProhibitedActionException() {
    }

    public ProhibitedActionException(String message) {
        super(message);
    }
}
