package cn.jomoon.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.jomoon.factory.BeanException;
import cn.jomoon.factory.PropertyValue;
import cn.jomoon.factory.config.BeanDefinition;
import cn.jomoon.factory.config.BeanReference;
import cn.jomoon.factory.core.io.Resource;
import cn.jomoon.factory.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{
    public static final String BEAN = "bean";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CLASS = "class";
    public static final String PROPERTY = "property";
    public static final String VALUE = "value";
    public static final String REF = "ref";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeanException {

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeanException {

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeanException {

    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        final Document doc = XmlUtil.readXML(inputStream);
        final Element root = doc.getDocumentElement();

        final NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }

            if (!BEAN.equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            final Element bean = (Element) childNodes.item(i);
            final String id = bean.getAttribute(ID);
            final String name = bean.getAttribute(NAME);
            final String className = bean.getAttribute(CLASS);

            final Class<?> clazz = Class.forName(className);

            String beanName = StrUtil.isNotEmpty(id) ? id : name;

            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }
            final BeanDefinition beanDefinition = new BeanDefinition(clazz);

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(childNodes.item(i) instanceof Element)) {
                    continue;
                }

                if (!PROPERTY.equals(childNodes.item(j).getNodeName())) {
                    continue;
                }

                // 解析标签 property
                Element property = (Element) bean.getChildNodes().item(j);

                String attrName = property.getAttribute(NAME);
                String attrValue = property.getAttribute(VALUE);
                String attrRef = property.getAttribute(REF);

                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addProperty(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeanException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
