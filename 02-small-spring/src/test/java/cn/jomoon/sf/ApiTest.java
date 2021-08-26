package cn.jomoon.sf;

import cn.jomoon.sf.bean.UserService;
import cn.jomoon.sf.factory.config.BeanDefinition;
import cn.jomoon.sf.factory.support.DefaultListableBeanFactory;
import org.junit.Assert;
import org.junit.Test;

public class ApiTest {

    public static final String USER_SERVICE = "userService";

    @Test
    public void test_BeanFactory() {
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        final BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        beanFactory.registerBeanDefinition(USER_SERVICE,beanDefinition);

        final UserService userService = (UserService) beanFactory.getBean(USER_SERVICE);
        userService.queryUserInfo();

        Assert.assertTrue(userService.equals(beanFactory.getBean(USER_SERVICE)));

    }
}
