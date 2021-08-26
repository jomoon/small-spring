package cn.jomoon.sf.factory.support;

import cn.jomoon.sf.factory.config.BeanDefinition;
import cn.jomoon.sf.factory.BeanFactory;

/**
 * 继承了 DefaultSingletonBeanRegistry 默认 单例的实现
 * 将getBean的流程固定在 AbstractBeanFactory 中
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        final Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        final BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
