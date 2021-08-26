package cn.jomoon.factory.support;

import cn.jomoon.factory.BeanException;
import cn.jomoon.factory.core.io.Resource;
import cn.jomoon.factory.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;
}
