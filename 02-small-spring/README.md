## 目标

- 将本BeanDefinition的属性改成仅存储类的信息而不存储其他的信息
- 使用模版设计方法来抽提通用核心方法的调用逻辑和标准定义。 子抽象类继承父抽象类，会实现自己的抽象方法
- 定义了 SingletonBeanRegistry接口定义，DefaultSingletonBeanRegistry 对接实现后，会被AbstractBeanFactory继承。