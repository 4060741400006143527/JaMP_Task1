package kz.epam.principles.behavior.exception;

public class UnsupportedMovementException extends Exception {

    public UnsupportedMovementException() {
    }

    public UnsupportedMovementException(String message) {
        super(message);
    }
}
