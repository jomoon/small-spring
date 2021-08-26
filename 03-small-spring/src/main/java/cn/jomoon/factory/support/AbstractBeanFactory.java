package cn.jomoon.factory.support;

import cn.jomoon.factory.BeanException;
import cn.jomoon.factory.BeanFactory;
import cn.jomoon.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) throws BeanException {
        final Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        final BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }


    public abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;


    public abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;
}
