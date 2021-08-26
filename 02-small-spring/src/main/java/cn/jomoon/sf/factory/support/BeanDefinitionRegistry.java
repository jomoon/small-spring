package cn.jomoon.sf.factory.support;

import cn.jomoon.sf.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    /**
     * 向注册表
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
