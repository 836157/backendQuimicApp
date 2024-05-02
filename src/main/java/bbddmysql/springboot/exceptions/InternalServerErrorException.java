package bbddmysql.springboot.exceptions;

public class InternalServerErrorException extends RuntimeException {

    private static final String DESCRIPTION = "Internal Server Error Exception (500)";

    public InternalServerErrorException(String message) {
        super(DESCRIPTION + ": " + message);
    }
}
