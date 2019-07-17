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


mybatis 注册别名，没有过滤内部类，匿名类，接口
如果存在两个匿名类，getSimpleName会拿到空串，注册到Map中，会报错
