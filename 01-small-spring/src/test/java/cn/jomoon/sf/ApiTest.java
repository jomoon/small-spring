package cn.jomoon.sf;

import cn.jomoon.sf.bean.UserService;
import org.junit.Test;

public class ApiTest {

    public static final String USER_SERVICE = "userService";

    @Test
    public void test_BeanFactory() {
        final BeanFactory beanFactory = new BeanFactory();

        final BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        beanFactory.registerBeanDefinition(USER_SERVICE, beanDefinition);

        final UserService userService = (UserService) beanFactory.getBean(USER_SERVICE);

        userService.queryUserInfo();


    }
}
