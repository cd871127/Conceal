package io.github.cd871127.conceal.dp.structure.decorator;

public class JobContextDecorator extends JobDecorator {
    public JobContextDecorator(Job job) {
        super(job);
    }

    @Override
    public void go() {
        System.out.println("init");
        super.go();
        System.out.println("clean");
    }
}
