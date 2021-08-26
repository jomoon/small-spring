package cn.jomoon.factory.support;

import cn.jomoon.factory.BeanException;
import cn.jomoon.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {
    /**
     *
     * @param beanDefinition bean定义信息
     * @param beanName bean的名称
     * @param ctor 构造器
     * @param args 传入参数
     * @return
     * @throws BeanException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;
}
