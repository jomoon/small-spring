package cn.jomoon.factory.config;

import cn.jomoon.factory.PropertyValues;

public class BeanDefinition {
    private Class clazz;

    private PropertyValues propertyValues;

    public BeanDefinition(Class clazz) {
        this(clazz, null);
    }

    public BeanDefinition(Class clazz, PropertyValues propertyValues) {
        this.clazz = clazz;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getClazz() {
        return clazz;
    }


    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
