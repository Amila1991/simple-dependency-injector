package org.cordnerds.simple.dependency.injector.exception;

/**
 * @author Amila Karunathilaka
 */
public class DIInstanceCreationException extends RuntimeException {

    public DIInstanceCreationException(String message) {
        super(message);
    }

    public DIInstanceCreationException(String message, Object... args) {
        super(args.length > 0 ? DIInstanceCreationException.generateMessage(message, args) : message);
    }

    public DIInstanceCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DIInstanceCreationException(String message, Throwable cause, Object... args) {
        super(args.length > 0 ? DIInstanceCreationException.generateMessage(message, args) : message, cause);
    }

    private static String generateMessage(String message, Object... args) {
        int index = 0;
        while (message.contains("{}") && index < args.length) {
            message = message.replaceFirst("\\{\\}", String.valueOf(args[index++]));
        }
        return message;
    }
}
