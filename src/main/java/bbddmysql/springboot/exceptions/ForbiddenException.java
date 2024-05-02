package bbddmysql.springboot.exceptions;

public class ForbiddenException extends RuntimeException {

    private static final String DESCRIPTION = "Prohibido, no posee rol necesario (403)";

    public ForbiddenException(String message) {
        super(DESCRIPTION + ": " + message);
    }
}
