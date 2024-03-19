package Exception;

/**
 * InvalidAnimalBirthDateException, наследует {@link Exception}.
 */
public class InvalidAnimalBirthDateException extends Exception {
    public InvalidAnimalBirthDateException(String message) {
        super(message);
    }
}
