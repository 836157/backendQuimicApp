package bbddmysql.springboot.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    private static final String DESCRIPTION = "Usuario ya existe (00_U001)";

    public UserAlreadyExistsException(String message) {
        super(DESCRIPTION + ": " + message);
    }
}
