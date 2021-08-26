package cn.jomoon.factory;

public interface BeanFactory {

    Object getBean(String name);

    /**
     * 增加重载方法传递入参给构造函数实例化
     * @param name
     * @param args
     * @return
     */
    Object getBean(String name, Object ... args);

}
