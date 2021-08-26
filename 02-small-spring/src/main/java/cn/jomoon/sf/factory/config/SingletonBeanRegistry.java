package cn.jomoon.sf.factory.config;

/**
 * 单例注册接口的定义和实现
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
