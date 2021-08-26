package cn.jomoon.sf.factory.support;

import cn.jomoon.sf.factory.config.BeanDefinition;

/**
 * 如果构造函数有入参怎么处理
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getClazz().getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
