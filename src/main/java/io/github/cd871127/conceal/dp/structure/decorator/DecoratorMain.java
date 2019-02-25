package io.github.cd871127.conceal.dp.structure.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Job job = new JobLogDecorator(new JobContextDecorator(new ConcreteJob()));
        job.go();
    }
}
