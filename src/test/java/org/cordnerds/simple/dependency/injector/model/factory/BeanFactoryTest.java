package org.cordnerds.simple.dependency.injector.model.factory;

import org.cordnerds.simple.dependency.injector.mock.insatnce.MockNonComponent;
import org.cordnerds.simple.dependency.injector.model.Bean;
import org.cordnerds.simple.dependency.injector.model.scop.Scope;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Amila Karunathilaka
 */
public class BeanFactoryTest {

    @Test
    public void buildBeanTestWithSingletonScope() {
        MockNonComponent component = new MockNonComponent();
        Bean bean = BeanFactory.buildBean(Scope.SINGLETON, component);
        Assert.assertNotNull(bean);
        Assert.assertEquals(Scope.SINGLETON, bean.getScope());
        Assert.assertEquals(component, bean.getInstance());
        Assert.assertEquals(component.getClass(), bean.getInstanceType());
    }

    @Test
    public void buildBeanTestWithProtoTypeScope() {
        MockNonComponent component = new MockNonComponent();
        Bean bean = BeanFactory.buildBean(Scope.PROTOTYPE, component);
        Assert.assertNotNull(bean);
        Assert.assertEquals(Scope.PROTOTYPE, bean.getScope());
        Assert.assertNotEquals(component, bean.getInstance());
        Assert.assertEquals(component.getClass(), bean.getInstanceType());
    }
}
