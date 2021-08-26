package cn.jomoon.factory.support;

import cn.jomoon.factory.BeanException;
import cn.jomoon.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException {
        final Class clazz = beanDefinition.getClazz();

        try {
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new BeanException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
