package io.github.cd871127.conceal;

public class Father {

    private Init init = new Init("Father member");
    private static Init init2 = new Init("Father static member");

    static {
        System.out.println("Father Static");
    }

    {
        System.out.println("Father inner");
    }

    public Father() {
        System.out.println("Father Constructor");
    }

    public static void main(String[] args) {
        new Child();
    }
}

class Child extends Father {

    private Init init = new Init("Child member");
    private static Init init2 = new Init("Child static member");

    static {
        System.out.println("Child Static");
    }

    {
        System.out.println("Child inner");
    }

    public Child() {
        System.out.println("Child Constructor");
    }

}

class Init {
    public Init(String arg) {
        System.out.println(arg);
    }
}
