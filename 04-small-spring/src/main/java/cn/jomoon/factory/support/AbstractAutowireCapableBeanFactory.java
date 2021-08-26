package cn.jomoon.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.jomoon.factory.BeanException;
import cn.jomoon.factory.PropertyValue;
import cn.jomoon.factory.PropertyValues;
import cn.jomoon.factory.config.BeanDefinition;
import cn.jomoon.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    // 这里来选择 具体实现是什么？
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException {
        Object bean = null;

        bean = createBeanInstance(beanDefinition, beanName, args);
        applyPropertyValues(beanName, bean, beanDefinition);
        addSingleton(beanName, bean);
        return bean;
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        final PropertyValues propertyValues = beanDefinition.getPropertyValues();

        final PropertyValue[] propertyValueList = propertyValues.getPropertyValueList();
        for (PropertyValue propertyValue : propertyValueList) {
            final String name = propertyValue.getName();
            Object value = propertyValue.getValue();

            if (value instanceof BeanReference) {
                final BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());
            }

            BeanUtil.setProperty(bean, name, value);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        final Class beanClass = beanDefinition.getClazz();
        final Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor ctor : declaredConstructors) {
            // 当参数数量相同的时候就进行匹配
            if (args != null && ctor.getParameterTypes().length == args.length)  {
                constructor = ctor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);


    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }



}
