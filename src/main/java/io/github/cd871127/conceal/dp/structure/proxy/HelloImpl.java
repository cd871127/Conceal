package io.github.cd871127.conceal.dp.structure.proxy;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi");
    }
}
