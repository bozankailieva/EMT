package finki.mk.emt_lab_1.model.exceptions;

public class HostNotFoundException extends RuntimeException {
    public HostNotFoundException(String message) {
        super(message);
    }
}
