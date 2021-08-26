package cn.jomoon.factory;

import cn.jomoon.factory.bean.UserDao;
import cn.jomoon.factory.bean.UserService;
import cn.jomoon.factory.config.BeanDefinition;
import cn.jomoon.factory.config.BeanReference;
import cn.jomoon.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    public static final String USER_SERVICE = "userService";
    public static final String USER_DAO = "userDao";

    @Test
    public void test_BeanFactory() {
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition(USER_DAO, new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addProperty(new PropertyValue("id", "10001"));
        propertyValues.addProperty(new PropertyValue(USER_DAO, new BeanReference(USER_DAO)));

        final BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition(USER_SERVICE, beanDefinition);
        final UserService userService = (UserService) beanFactory.getBean(USER_SERVICE, "pig");
        userService.queryUserInfo();

    }
}
