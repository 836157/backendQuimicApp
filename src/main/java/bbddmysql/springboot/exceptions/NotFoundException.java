package bbddmysql.springboot.exceptions;

public class NotFoundException extends RuntimeException{

        private static final String DESCRIPTION = "Excepción no definida (404)";
        public NotFoundException(String message) {
            super(DESCRIPTION + ": " + message);
        }
}
