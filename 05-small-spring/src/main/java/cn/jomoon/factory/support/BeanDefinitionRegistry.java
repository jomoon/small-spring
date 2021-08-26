package cn.jomoon.factory.support;

import cn.jomoon.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);


    boolean containsBeanDefinition(String beanName);
}
