package bbddmysql.springboot.exceptions;

public class QuestionInsertionFailedException extends RuntimeException {

    private static final String DESCRIPTION = "Error al insertar la pregunta (00_P001)";

    public QuestionInsertionFailedException(String message) {
        super(DESCRIPTION + ": " + message);
    }
}
