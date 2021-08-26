package cn.jomoon.factory.config;

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
