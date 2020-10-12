package org.cordnerds.simple.dependency.injector.model;

import org.cordnerds.simple.dependency.injector.exception.DIInstanceCreationException;
import org.cordnerds.simple.dependency.injector.mock.insatnce.MockArgsConstructorComponent;
import org.cordnerds.simple.dependency.injector.mock.insatnce.MockInnerPrototypeComponent;
import org.cordnerds.simple.dependency.injector.mock.insatnce.MockInnerSingletonComponent;
import org.cordnerds.simple.dependency.injector.mock.insatnce.MockNonComponent;
import org.cordnerds.simple.dependency.injector.model.scop.Scope;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Amila Karunathilaka
 */
public class PrototypeBeanTest {

    @Test
    public void getInstanceTest() {
        MockNonComponent component = new MockNonComponent();
        Bean bean = new ProtoTypeBean(component);
        Assert.assertNotNull(bean.getInstance());
        Assert.assertNotEquals(component, bean.getInstance());
    }

    @Test(expected = DIInstanceCreationException.class)
    public void getInstanceFailureTestArgsConstructorBean() {
        MockInnerSingletonComponent singletonComponent = new MockInnerSingletonComponent();
        MockInnerPrototypeComponent prototypeComponent = new MockInnerPrototypeComponent();
        MockArgsConstructorComponent component =
                new MockArgsConstructorComponent(singletonComponent, prototypeComponent);
        Bean bean = new ProtoTypeBean(component);
        bean.getInstance();
    }

    @Test
    public void getScopeTest() {
        Bean bean = new ProtoTypeBean<>(new MockNonComponent());
        Assert.assertEquals(Scope.PROTOTYPE, bean.getScope());
    }

    @Test
    public void getInstanceTypeTest() {
        Bean bean = new ProtoTypeBean(new MockNonComponent());
        Assert.assertEquals(MockNonComponent.class, bean.getInstanceType());
    }
}
