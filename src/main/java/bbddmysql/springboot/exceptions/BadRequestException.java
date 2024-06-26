package bbddmysql.springboot.exceptions;

public class BadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "Bad Request Exception (400)";

    public BadRequestException(String message) {
        super(DESCRIPTION+": "+message);
    }
}
