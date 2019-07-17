package io.github.cd871127.conceal.dp.structure.proxy.staticproxy;

import io.github.cd871127.conceal.dp.structure.proxy.Hello;

public class HelloProxy implements Hello {
    private Hello hello;

    public HelloProxy(Hello hello) {
        this.hello = hello;
    }


    @Override
    public void sayHello() {
        before();
        this.hello.sayHello();
        after();
    }

    @Override
    public void sayHi() {

    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
