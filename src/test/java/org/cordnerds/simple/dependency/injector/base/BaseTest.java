package org.cordnerds.simple.dependency.injector.base;

import org.junit.After;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * @author Amila Karunathilaka
 */
public class BaseTest {
    private AutoCloseable closeable;

    @Before
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }
}
