package cn.jomoon.sf.factory.support;

import cn.jomoon.sf.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjs = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjs.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjs.put(beanName, singletonObject);
    }
}
