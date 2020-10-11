package org.cordnerds.simple.dependency.injector.model;

import org.cordnerds.simple.dependency.injector.mock.insatnce.MockNonComponent;
import org.cordnerds.simple.dependency.injector.model.scop.Scope;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Amila Karunathilaka
 */
public class SingletonBeanTest {

    @Test
    public void getInstanceTest() {
        MockNonComponent component = new MockNonComponent();
        Bean bean = new SingletonBean<>(component);
        Assert.assertNotNull(bean.getInstance());
        Assert.assertEquals(component, bean.getInstance());
    }

    @Test
    public void getScopeTest() {
        Bean bean = new SingletonBean<>(new MockNonComponent());
        Assert.assertEquals(Scope.SINGLETON, bean.getScope());
    }

    @Test
    public void getInstanceTypeTest() {
        Bean bean = new SingletonBean<>(new MockNonComponent());
        Assert.assertEquals(MockNonComponent.class, bean.getInstanceType());
    }
}
