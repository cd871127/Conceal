package io.github.cd871127.conceal.dp.structure.decorator;

public class JobLogDecorator extends JobDecorator {
    public JobLogDecorator(Job job) {
        super(job);
    }

    @Override
    public void go() {
        System.out.println("job start");
        super.go();
        System.out.println("job done");
    }
}
