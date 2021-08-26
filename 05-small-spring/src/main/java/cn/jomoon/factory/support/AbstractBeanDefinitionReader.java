package cn.jomoon.factory.support;

import cn.jomoon.factory.core.io.DefaultResourceLoader;
import cn.jomoon.factory.core.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    // bean定义的reader为什么要持有 注册中心
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
