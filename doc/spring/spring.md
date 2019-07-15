# IOC

BeanFactory:
ApplicationContext:

IOC容器启动过程
1 Resource定位 ResourceLoader.getResource()
2 BeanDefinition载入 BeanDefinitionReader.loadBeanDefinitions()
3 注册BeanDefinition  BeanDefinitionRegistry.registerBeanDefinition()

beanDefinition.getMethodOverrides()
lookup-method, replaced-method 会用CGLIB注入
否则用构造方法

https://blog.csdn.net/chejinqiang/article/details/80003868