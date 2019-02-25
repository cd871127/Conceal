package io.github.cd871127.conceal.dp.structure.decorator;

public abstract class JobDecorator implements Job {

    private Job job;

    public JobDecorator(Job job) {
        this.job = job;
    }

    @Override
    public void go() {
        job.go();
    }

}
