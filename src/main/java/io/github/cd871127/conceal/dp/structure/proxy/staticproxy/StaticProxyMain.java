package io.github.cd871127.conceal.dp.structure.proxy.staticproxy;

import io.github.cd871127.conceal.dp.structure.proxy.Hello;
import io.github.cd871127.conceal.dp.structure.proxy.HelloImpl;

public class StaticProxyMain {
    public static void main(String[] args) {
        Hello hello = new HelloProxy(new HelloImpl());
        hello.sayHello();
    }
}
