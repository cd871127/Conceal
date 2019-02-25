package io.github.cd871127.conceal.dp.structure.proxy.cglib;

import io.github.cd871127.conceal.dp.structure.proxy.GoodBye;
import net.sf.cglib.proxy.Enhancer;

public class CGLibProxyMain {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        GoodBye goodBye = (GoodBye) Enhancer.create(GoodBye.class, cgLibProxy);
        goodBye.sayGoodBye();
    }
}
