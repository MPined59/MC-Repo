package circusprj;

import java.util.InputMismatchException;

class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}