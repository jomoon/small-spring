package cn.jomoon.factory;

import cn.jomoon.factory.bean.UserService;
import cn.jomoon.factory.config.BeanDefinition;
import cn.jomoon.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    public static final String USER_SERVICE = "userService";

    @Test
    public void test_BeanFactory() {
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        final BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition(USER_SERVICE, beanDefinition);
        final UserService userService = (UserService)beanFactory.getBean(USER_SERVICE, "pig");
        userService.queryUserInfo();

    }
}
