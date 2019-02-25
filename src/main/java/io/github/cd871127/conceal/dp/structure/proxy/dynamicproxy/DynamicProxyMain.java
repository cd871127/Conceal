package io.github.cd871127.conceal.dp.structure.proxy.dynamicproxy;

import io.github.cd871127.conceal.dp.structure.proxy.Hello;
import io.github.cd871127.conceal.dp.structure.proxy.HelloImpl;

import java.lang.reflect.Proxy;

public class DynamicProxyMain {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        Hello helloProxy = (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxy
        );
        helloProxy.sayHello();
    }
}
