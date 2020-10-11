package org.cordnerds.simple.dependency.injector.exception;

import org.junit.Test;

/**
 * @author Amila Karunathilaka
 */
public class DIInstanceCreationExceptionTest {

    @Test(expected = DIInstanceCreationException.class)
    public void testExceptionWithMessage() {
        throw new DIInstanceCreationException("Test Exception Message");
    }

    @Test(expected = DIInstanceCreationException.class)
    public void testExceptionWithMessageAndArg() {
        throw new DIInstanceCreationException("Test Exception Message : {}", "test arg");
    }

    @Test(expected = DIInstanceCreationException.class)
    public void testExceptionWithMessageAndThrow() {
        throw new DIInstanceCreationException("Test Exception Message with Throw",
                new RuntimeException("Test Runtime Exception"));
    }

    @Test(expected = DIInstanceCreationException.class)
    public void testExceptionWithMessageAndThrowAndArg() {
        throw new DIInstanceCreationException("Test Exception Message with Throw and {}",
                        new RuntimeException("Test Runtime Exception"), "test arg");
    }
}
