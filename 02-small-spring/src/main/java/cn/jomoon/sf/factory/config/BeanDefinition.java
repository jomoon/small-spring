package cn.jomoon.sf.factory.config;

public class BeanDefinition {
    private Class clazz;

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
