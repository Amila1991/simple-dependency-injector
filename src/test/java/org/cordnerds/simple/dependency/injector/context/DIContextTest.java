package org.cordnerds.simple.dependency.injector.context;

import org.cordnerds.simple.dependency.injector.exception.DIInstanceCreationException;
import org.cordnerds.simple.dependency.injector.mock.insatnce.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Amila Karunathilaka
 */
public class DIContextTest {

    @Test
    public void getContextTest() {
        Context context = DIContext.getContext();
        Assert.assertNotNull(context);
        Assert.assertEquals(DIContext.getContext(), context);
    }

    @Test
    public void getBeanTest() {
        Context context = DIContext.getContext();
        MockComponent component = context.getBean(MockComponent.class);
        Assert.assertNotNull(component);
        Assert.assertEquals(DIContext.getContext().getBean(MockInnerSingletonComponent.class),
                component.getInnerSingletonComponent());
        Assert.assertNotEquals(DIContext.getContext().getBean(MockInnerPrototypeComponent.class),
                component.getInnerPrototypeComponent());
    }

    @Test(expected = DIInstanceCreationException.class)
    public void getBeanTestFailureWithNonComponent() {
        Context context = DIContext.getContext();
        context.getBean(MockNonComponent.class);
    }

    @Test(expected = DIInstanceCreationException.class)
    public void getBeanTestFailureWithArgumentsConstructorComponent() {
        Context context = DIContext.getContext();
        context.getBean(MockArgsConstructorComponent.class);
    }
}
